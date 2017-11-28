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
package br.uefs.ecomp.lojasAsdrubals.main.controller;

import br.uefs.ecomp.lojasAsdrubals.main.model.Produto;
import java.io.IOException;
import java.time.LocalDate;
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
public class ControllerTest {
    
    public ControllerTest() {
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
     * Teste do método inserir da classe Controller.
     */
    @Test
    public void testInserir() {
        System.out.println("Inserir");
        String lote = "1";
        String endereco = "16587";
        String bloco = "B1";
        int numProduto = 513;
        String funcionario = "F1";
        String data = "16/07/2017";
        String hora = "12:00";
        Controller instance = new Controller();
        boolean expResult = true;
        boolean result = instance.inserir(lote, endereco, bloco, numProduto, funcionario, data, hora);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método de listar produtos da classe Controller.
     */
    @Test
    public void testListar_Produto() { 
        System.out.println("Listar Produto");
        Produto produto = null;
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.listar(produto);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método de ler no arquivo e inserir da classe Controller.
     * @throws java.lang.Exception
     */
    @Test
    public void testLerNoArquivoEInsere() throws Exception {
        System.out.println("Ler arquivo");
        String nome = "armazem.csv";
        Controller instance = new Controller();
        boolean expResult = true;
        boolean result = instance.lerNoArquivoEInsere(nome);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método de escrever no arquivo da classe Controller.
     * @throws java.lang.Exception
     */
    @Test
    public void testEscreverNoArquivo() throws Exception {
        System.out.println("Escrever no arquivo");
        Controller instance = new Controller();
        instance.lerNoArquivoEInsere("armazem.csv");
        ArrayList<Produto> lista = instance.listar();
        boolean result = instance.escreverNoArquivo(lista,"saida.csv");
        assertEquals(true,result);
    }

    @Test
    public void testListarOrdem() throws Exception{
        System.out.println("Lista por ordem");
        ArrayList<Produto> lista = new ArrayList<>();
        Controller instance = new Controller();
        instance.lerNoArquivoEInsere("armazem.csv");
        boolean result = instance.listagemOrdem();
        assertEquals(true,result);
    }
    /**
     * Teste do método de cadastrar mercadoria da classe Controller.
     */
    @Test
    public void testCadastrarMercadoria() {
        System.out.println("Cadastrar mercadoria");
        String lote = "8";
        String endereco = "16587";
        String bloco = "B1";
        int numProduto = 513;
        String funcionario = "F1";
        String data = "16/07/2017";
        String hora = "12:00";
        Controller instance = new Controller();
        boolean expResult = true;
        boolean result = instance.cadastrarMercadoria(lote, endereco, bloco, numProduto, funcionario, data, hora);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método de remover da classe Controller.
     */
    @Test
    public void testRemover() {
        System.out.println("Remover");
        String lote = "1";
        String endereco = "16587";
        String bloco = "B1";
        int numProduto = 513;
        String funcionario = "F1";
        String data = "16/07/2017";
        String hora = "12:00";
        Controller instance = new Controller();
        boolean expResult = true;
        boolean result = instance.remover(lote, endereco, bloco, numProduto, funcionario, data, hora);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método de busca da classe Controller.
     * @throws java.io.IOException
     */
    @Test
    public void testBusca() throws IOException {
        System.out.println("Buscar");
        String lote = "1";
        String endereco = "16587";
        String bloco = "B1";
        int numProduto = 513;
        String funcionario = "F1";
        String data = "16/07/2017";
        String hora = "12:00";
        Controller instance = new Controller();
        instance.lerNoArquivoEInsere("armazem.csv");
        boolean expResult = true;
        boolean result = instance.busca(lote, endereco, bloco, numProduto, funcionario, data, hora);
        assertEquals(expResult, result);
    }

    /**
     * Teste do método de contagem da classe Controller.
     * @throws java.lang.Exception
     */
    @Test
    public void testContador() throws Exception {
        System.out.println("Contador");
        String nome = "armazem.csv";
        Controller instance = new Controller();
        int expResult = 5;
        int result = instance.Contador(nome);
        assertEquals(expResult, result);
    }
    
}
