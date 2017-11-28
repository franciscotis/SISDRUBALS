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

/**
 *
 * @author Abel Galvão / Francisco Tito
 */

public class AvlNode {
    public Produto elemento;
    public AvlNode esquerda;
    public AvlNode direita;
    public AvlNode pai;
    private int balanceamento;
    private int altura;
    
    /**
     * Construtor AvlNode.
     * @param el - Produto
    */
    public AvlNode(Produto el){
        this.esquerda = this.direita = this.pai = null;
        this.balanceamento = 0;
        this.elemento = el;
    }

    /**
     * Get elemento.
     * @return elemento
    */
    public Produto getElemento() {
        return elemento;
    }

    /**
     * Set elemento.
     * @param elemento - Produto
    */
    public void setElemento(Produto elemento) {
        this.elemento = elemento;
    }

    /**
     * Get esquerda.
     * @return esquerda
    */
    public AvlNode getEsquerda() {
        return esquerda;
    }

    /**
     * Set esquerda.
     * @param esquerda - AvlNode
    */
    public void setEsquerda(AvlNode esquerda) {
        this.esquerda = esquerda;
    }

    /**
     * Get direita.
     * @return direira
    */
    public AvlNode getDireita() {
        return direita;
    }

    /**
     * Set direita.
     * @param direita - AvlNode
    */
    public void setDireita(AvlNode direita) {
        this.direita = direita;
    }

    /**
     * Get pai.
     * @return pai
    */
    public AvlNode getPai() {
        return pai;
    }

    /**
     * Set pai.
     * @param pai - AvlNode
    */
    public void setPai(AvlNode pai) {
        this.pai = pai;
    }

    /**
     * Get balanceamanto.
     * @return balanceamento
    */
    public int getBalanceamento() {
        return balanceamento;
    }

    /**
     * Set balanceamanto.
     * @param balanceamanto - int
    */
    public void setBalanceamento(int balanceamento) {
        this.balanceamento = balanceamento;
    }

    /**
     * Get altura.
     * @return altura
    */
    public int getAltura() {
        return altura;
    }

    /**
     * Set altura.
     * @param altura - int
    */
    public void setAltura(int altura) {
        this.altura = altura;
    }
    

}