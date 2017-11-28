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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Abel Galvão / Francisco Tito
 */
public class ArvoreTest {
    
    public ArvoreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of tamanho method, of class Arvore.
     */
    @Test
    public void testTamanho() {
        System.out.println("Tamanho");
        Arvore instance = new Arvore();
        int expResult = 0;
        int result = instance.tamanho();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método altura da classe Arvore.
     */
    @Test
    public void testAltura() {
        System.out.println("Altura");
        AvlNode t = null;
        Arvore instance = new Arvore();
        int expResult = -1;
        int result = instance.altura(t);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método isEmpty da classe Arvore.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("Está vazio");
        Arvore instance = new Arvore();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método insere da classe Arvore.
     */
    @Test
    public void testInsere() {
        System.out.println("Insere");
        Produto elemento = null;
        Arvore instance = new Arvore();
        boolean expResult = true;
        boolean result = instance.insere(elemento);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método buscar da class Arvore.
     */
    @Test
    public void testBuscar() {
        System.out.println("Buscar");
        Produto elemento = null;
        Arvore instance = new Arvore();
        boolean expResult = false;
        boolean result = instance.buscar(elemento);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método insere naaArvore da classe Arvore.
     */
    @Test
    public void testInsereNaArvore() {
        System.out.println("Insere na árvore");
        AvlNode raiz = null;
        AvlNode insere = null;
        Arvore instance = new Arvore();
        instance.insereNaArvore(raiz, insere);
    }


    /**
     * Teste do método Tree2Array da classe Arvore.
     */
    @Test
    public void testTree2Array_AvlNode_ArrayList() {
        System.out.println("Tree 2 Array");
        AvlNode no = null;
        ArrayList<Produto> lista = null;
        Arvore instance = new Arvore();
        instance.Tree2Array(no, lista);
    }

    /**
     * Teste do método remover AVL da classe Arvore.
     */
    @Test
    public void testRemoverAVL_Produto() {
        System.out.println("Remover AVL");
        Produto e = null;
        Arvore instance = new Arvore();
        instance.removerAVL(e);
    }

    /**
     * Teste do método remover AVL da classe Arvore.
     */
    @Test
    public void testRemoverAVL_AvlNode_Produto() {
        System.out.println("Remover AVL");
        AvlNode no = null;
        Produto remover = null;
        Arvore instance = new Arvore();
        instance.removerAVL(no, remover);
    }

  
    
}
