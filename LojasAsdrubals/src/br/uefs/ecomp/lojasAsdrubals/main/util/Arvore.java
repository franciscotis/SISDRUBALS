/*******************************************************************************
Autores: Abel Ramalho Galvão / Francisco Tito Silva Santos Pereira
Componente Curricular: MI Programação
Concluido em: 16/07/2017
Declaramos que este código foi elaborado por nós e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/
package br.uefs.ecomp.lojasAsdrubals.main.util;

import br.uefs.ecomp.lojasAsdrubals.main.model.Produto;
import java.util.ArrayList;

/**
 *
 * @author Abel Galvão / Francisco Tito
 */

public class Arvore {

    private AvlNode raiz;
    private int tamanho;

    /**
     * Construtor da Arvore.
     * @param raiz
    */
    public Arvore() {
        this.raiz = null;
    }

    /**
     * Metodo tamanho.
     * @return tamanho da arvore
    */
    public int tamanho() {
        return this.tamanho;
    }

    /**
     * Metodo altura.
     * @return altura do nó
    */
    public int altura(AvlNode t) {
        return t == null ? -1 : t.getAltura();
    }

    /**
     * Metodo isEmpty.
     * @return true caso a árvore esteja vazia
    */
    public boolean isEmpty() {
        return raiz == null;
    }

    /**
     * Metodo max. Verifica qual é o maior dos dois numeros
     * @param a - int
     * @param b - int
     * @return  a caso a seja maior que b
    */
    private int max(int a, int b) {
        return a > b ? a : b;
    }

    /**
     * Metodo insere. Insere um produto na árvore
     * @param elemento - Produto
     * @return boolean true, caso insira com sucesso
    */
    public boolean insere(Produto elemento) {
        AvlNode n = new AvlNode(elemento);
        insereNaArvore(raiz, n);
        return true;
    }

    /**
     * Metodo buscar.
     * @param elemento - Produto
     * @return true caso o elemento esteja na árvore
    */
    public boolean buscar(Produto elemento) {
        return buscar(this.raiz, elemento);
    }

    /**
     * Metodo buscar.
     * @param atual - AvlNode - nó da árvore
     * @param elemento - Produto
     * @return boolean true se encontar o elemento na árvore
    */
    private boolean buscar(AvlNode atual, Produto elemento) {
        if (atual == null) {
            return false;
        }

        if (elemento.compareTo(atual.getElemento()) < 0) {
            return buscar(atual.getEsquerda(), elemento); // Caso o elemento possa estar na esquerda
        } else if (elemento.compareTo(atual.getElemento()) > 0) {
            return buscar(atual.getDireita(), elemento); // Caso o elemento possa estar na direita
        } else {
            return true;
        }
    }

    /**
     * Metodo insere na arvore. É um método recursivo que compara o conteudo existente 
     * no método que será inserido. Caso ele seja menor que a raiz ele será inserido na 
     * esquerda, e caso seja maior será inserido na direita.  Após a insersão, a árvore
     * é balanceada
     *
     * @param raiz - AvlNode - Nó raiz
     * @param insere - AvlNode - Nó que será inserido
    */
    public void insereNaArvore(AvlNode raiz, AvlNode insere) {
        if (raiz == null) {
            this.raiz = insere;
            tamanho++;
        } else {
            if (insere.getElemento().compareTo(raiz.getElemento()) > 0) {
                if (raiz.getEsquerda() == null) {
                    raiz.setEsquerda(insere);
                    insere.setPai(raiz);
                    balancear(raiz);
                } else {
                    insereNaArvore(raiz.getEsquerda(), insere);
                }
            } else if (insere.getElemento().compareTo(raiz.getElemento()) < 0) {
                if (raiz.getDireita() == null) {
                    raiz.setDireita(insere);
                    insere.setPai(raiz);
                    balancear(raiz);
                } else {
                    insereNaArvore(raiz.getDireita(), insere);
                    balancear(raiz);
                }
            }

        }
    }

    /**
     * Metodo balancear. Irá balancear a árvore até que cada nó tenha fator de balanceamento
     * igual a 1, -1 e 0. Para fazer o balanceamento, serão feitas rotações, pela esquerda,
     * direita ou duplamente para esquerda/direita. 
     * @param t - AvlNode - nó a ser balanceado
     * @return AvlNode t - nó balanceado
    */
    public AvlNode balancear(AvlNode t) {
        SetFactor(t);
        int balanceamento = t.getBalanceamento();

        if (balanceamento == -2) {

            if (altura(t.getEsquerda().getEsquerda()) >= altura(t.getEsquerda().getDireita())) {
                t = RotacaoDireita(t);

            } else {
                t = DuplaRotacaoDireita(t);
            }

        } else if (balanceamento == 2) {

            if (altura(t.getDireita().getDireita()) >= altura(t.getDireita().getEsquerda())) {
                t = RotacaoEsquerda(t);

            } else {
                t = DuplaRotacaoEsquerda(t);
            }
        }

        if (t.getPai() != null) {
            balancear(t.getPai());
        } else {
            this.raiz = t;
        }
        return t;
    }
    

     /**
     * Metodo para mudar o fator de balanceamento do nó.
     * @param no - AvlNode - nó da árvore.
    */
    private void SetFactor(AvlNode no) {
        no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
    }


    /**
     * Metodo de rotação para direita.
     * @param a - AvlNode - nó da árvore
    */
    private AvlNode RotacaoDireita(AvlNode a) {
        AvlNode b = a.getEsquerda();
        a.setEsquerda(b.getDireita());
        b.setDireita(a);
        a.setAltura(max(altura(a.getEsquerda()), altura(a.getDireita()) + 1));
        b.setAltura(max(altura(b.getEsquerda()), a.getAltura() + 1));
        return b;
    }

    /**
     * Metodo de rotação para esquerda.
     * @param a - AvlNode - nó da árvore
    */
    private AvlNode RotacaoEsquerda(AvlNode a) {
        AvlNode b = a.getDireita();
        a.setDireita(b.getEsquerda());
        b.setEsquerda(a);
        a.setAltura(max(altura(a.getEsquerda()), altura(a.getDireita()) + 1));
        b.setAltura(max(altura(b.getDireita()), a.getAltura() + 1));
        return b;
    }

    /**
     * Metodo de dupla rotação para direita.
     * @param k3 - AvlNode
    */
    private AvlNode DuplaRotacaoDireita(AvlNode k3) {
        k3.setEsquerda(RotacaoEsquerda(k3.getEsquerda()));
        return RotacaoDireita(k3);
    }

    /**
     * Metodo de dupla rotação para esquerda.
     * @param k1 - AvlNode
    */
    private AvlNode DuplaRotacaoEsquerda(AvlNode k1) {
        k1.setDireita(RotacaoDireita(k1.getDireita()));
        return RotacaoEsquerda(k1);
    }

    /**
     * Metodo Tree2Array. Passa as informações contidas na árvore para um ArrayList
     * @return ret. O arraylist criado
    */
    public ArrayList<Produto> Tree2Array() {
        ArrayList<Produto> ret = new ArrayList<Produto>();
        Tree2Array(this.raiz, ret);
        return ret;
    }

    /**
     * Metodo Tree2Array. Passa as informações contidas na árvore para um ArrayList
     * @param no - AvlNode - nó da lista 
     * @param lista - ArrayList<Produto> - array onde as informações da árvore serão passadas
    */
    public void Tree2Array(AvlNode no, ArrayList<Produto> lista) {
        if (no == null) {
            return;
        }
        Tree2Array(no.getEsquerda(), lista);
        lista.add(no.getElemento());
        Tree2Array(no.getDireita(), lista);
    }

    /**
     * Metodo removerAVL. Método de remover um elemento da árvore
     * @param e - Produto - Elemento a ser removido
    */
    public void removerAVL(Produto e) {
        removerAVL(this.raiz, e);
    }
    

    /**
     * Metodo removerAVL. Esse método irá remover um elemento da árvore, primeiramente 
     * irá fazer comparações entre esse elemento que quer ser removido e o elemento presente
     * na árvore, passado como parâmetro. É um método recursivo, no qual será executado até que 
     * o nó seja encontrado. Caso o elemento procurado seja menor que o elemento presente no nó
     * passado como parâmentro, ele será procurado na esquerda da árvore. Caso contrario, na direita
     * @param no - AvlNode - Nó da árvore para ser iniciada a procua
     * @param remover - Produto - elemento a ser removido 
    */
    public void removerAVL(AvlNode no, Produto remover) {
        if (no == null) {
            return;
        } else {
            if (no.getElemento().compareTo(remover) < 0) {
                removerAVL(no.getEsquerda(), remover);
            } else if (no.getElemento().compareTo(remover) > 0) {
                removerAVL(no.getDireita(), remover);
            } else {
                remover(no);
                tamanho--;
            }
        }
    }

    /**
     * Metodo remover. Após encontrar o nó, ele irá ser removido. Caso o nó seja uma raiz,
     * a raiz será nula. Caso ele tenha somente um filho, esse nó filho fica no lugar do nó
     * a ser removido (o seu pai), caso ele tenha dois filhos, o seu sucessor (método prox)
     * será encontrado e ficará no lugar do nó pai
     * @param rem - AvlNode
    */
    public void remover(AvlNode rem) {
        AvlNode remove;
        if (rem.getEsquerda() == null || rem.getDireita() == null) { 
            if (rem.getPai() == null && rem.getEsquerda() == null && rem.getDireita() == null) {
                this.raiz = null;
                return;
            }
            remove = rem;
        } else {
            remove = prox(rem);
            rem.setElemento(remove.getElemento());
        }
        AvlNode aux1;
        if (remove.getEsquerda() != null) {
            aux1 = remove.getEsquerda();
        } else {
            aux1 = remove.getDireita();
        }
        if (aux1 != null) {
            aux1.setPai(remove.getPai());
        }
        if (remove.getPai() == null) {
            this.raiz = aux1;
        } else {
            if (remove == remove.getPai().getEsquerda()) {
                remove.getPai().setEsquerda(aux1);
            } else {
                remove.getPai().setDireita(aux1);
            }
            balancear(remove.getPai());
        }
    }

    /**
     * Metodo prox. Irá encontrar o filho sucessor de um determinado nó
     * @param a - AvlNode - nó o qual deseja encontrar o seu sucessor
     * @return - AvlNode c - seu sucessor
    */
    private AvlNode prox(AvlNode a) {
        if (a.getDireita() != null) {
            AvlNode b = a.getDireita();
            while (b.getEsquerda() != null) {
                b = b.getEsquerda();
            }
            return b;
        } else {
            AvlNode c = a.getPai();
            while (c != null && a == c.getDireita()) {
                a = c;
                c = a.getPai();
            }
            return c;
        }
    }


}
