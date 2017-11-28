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
import br.uefs.ecomp.lojasAsdrubals.main.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Abel Galvão / Francisco Tito
 */

public class Controller {

    private Arvore arvore;

    public Controller() {
        arvore = new Arvore();

    }

    /**
     * Método de listar.
     * @return um arraylist com o conteúdo da árvore
     */
    public ArrayList listar() {
        return arvore.Tree2Array();
    }

    /**
     * Método inserir.
     * @param lote - String 
     * @param endereco - String
     * @param bloco - String 
     * @param numProduto - int
     * @param funcionario - String
     * @param data - String 
     * @param hora - String
     * @return boolean - true caso insira com sucesso e false caso contrário
     */
    public boolean inserir(String lote, String endereco, String bloco, int numProduto, String funcionario, String data, String hora) {
        Produto novo = new Produto(lote, endereco, bloco, numProduto, funcionario, data, hora);
        return arvore.insere(novo);
    }

    /**
     * Método de listar produtos.
     * @param produto - Produto
     * @return boolean - true caso liste com sucesso e false caso contrário
     */
    public boolean listar(Produto produto) {
        return arvore.buscar(produto);
    }

    /**
     * Método de ler no arquivo e inserir.
     * @param nome - String
     * @return boolean - true caso leia no arquivo e insira com sucesso na árvore
     * @throws java.io.IOException
     */
    public boolean lerNoArquivoEInsere(String nome) throws IOException {
        boolean a = false;
        FileReader arquivo = new FileReader(nome);
        BufferedReader br = new BufferedReader(arquivo);
        String linha = "";
        try {
            do {
                linha = br.readLine();
                if (linha != null) {
                    String[] itens = linha.split(";");
                    int numProduto = Integer.parseInt(itens[3]);
                    a = inserir(itens[0], itens[1], itens[2], numProduto, itens[4],itens[5], itens[6]);
                }
            } while (linha != null);
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo!");
        } finally {
            arquivo.close();
            br.close();
        }
        return a;
    }

    /**
     * Método de escrever no arquivo.
     * @param lista
     * @param nomeDoArquivo
     * @return - boolean - true caso escreva no arquivo com sucesso
     * @throws java.io.FileNotFoundException
     */
    public boolean escreverNoArquivo(ArrayList<Produto> lista,String nomeDoArquivo) throws FileNotFoundException, IOException {
        File file = new File(nomeDoArquivo);
        FileWriter f = new FileWriter(file);
        f.flush();
        Produto nome = null;
        String conteudo;
        boolean result = false;
        try {
            for (int i = 0; i < lista.size(); i++) {
                nome = lista.get(i);
                conteudo = nome.arquivo();
                conteudo += "\r\n";
                f.write(conteudo);
            }
            result = true;
        } catch (Exception e) {
            System.out.println("Erro ao escrever o arquivo!");
            result = false;
        } finally {
            f.close();
        }
        return result;
    }

    /**
     * Método de cadastrar mercadoria.
     * @param lote - String 
     * @param endereco - String
     * @param bloco - String 
     * @param numProduto - int
     * @param funcionario - String
     * @param data - String 
     * @param hora - String
     * @return boolean - true caso cadastre a mercadoria com sucesso
     */
    public boolean cadastrarMercadoria(String lote, String endereco, String bloco, int numProduto, String funcionario, String data, String hora) {
        Produto p = new Produto(lote, endereco, bloco, numProduto, funcionario, data, hora);
        arvore.insere(p);
        return true;
    }

    /**
     * Método de remover.
     * @param lote - String 
     * @param endereco - String
     * @param bloco - String 
     * @param numProduto - int
     * @param funcionario - String
     * @param data - String 
     * @param hora - String
     * @return boolean - caso remova com sucesso
     */
    public boolean remover(String lote, String endereco, String bloco, int numProduto, String funcionario, String data, String hora) {
        Produto p = new Produto(lote, endereco, bloco, numProduto, funcionario, data, hora);
        arvore.removerAVL(p);
        return true;
    }

    /**
     * Método de busca.
     * @param lote - String 
     * @param endereco - String
     * @param bloco - String 
     * @param numProduto - int
     * @param funcionario - String
     * @param data - LocalDate 
     * @param hora - String
     * @return boolean - true caso o elemento exista
     */
    public boolean busca(String lote, String endereco, String bloco, int numProduto, String funcionario, String data, String hora) {
        Produto p = new Produto(lote, endereco, bloco, numProduto, funcionario, data, hora);
        return arvore.buscar(p);
    }
    
    /**
     * Método de contagem.
     * @param nome
     * @return int - Quantidade de linhas no arquivo
     * @throws java.io.FileNotFoundException
     */
    public int Contador(String nome) throws FileNotFoundException, IOException{
        LineNumberReader lC = new LineNumberReader(new InputStreamReader(new FileInputStream(nome)));
        String line = null;
        try{
            while((line =lC.readLine())!=null){
                if(line==null){
                    break;
                }
            }
        }
        catch(Exception done){
            done.printStackTrace();
        }
        return lC.getLineNumber();
    }
    
    /**
     * Método de listagem por ordem numerica
     */
    public boolean listagemOrdem() throws IOException{
        ArrayList <Produto> pd = listar();
        sort(pd);
        return escreverNoArquivo(pd,"listagem.csv");
    }
     /////////////////////QUICKSORT///////////////////////////////////
    
    ArrayList<Produto> names; //Array do tipo Produto
    int length; //atributo que representa o tamanho
    public void sort(ArrayList<Produto> array){ //Método que vai realizar a ordenação
        if (array == null || array.size()== 0) { //Se o array estiver vazio 
            return; //Não faz nada
        } 
        this.names = array; //Caso contrario 
        this.length = array.size();
        quickSort(0, length - 1); //Realiza a ordenação
    }
    void quickSort(int lowerIndex, int higherIndex) { //Metodo que irá realizar a ordenação
        int i = lowerIndex;
        int j = higherIndex;
        Produto pivot = this.names.get(lowerIndex + (higherIndex - lowerIndex) / 2);
       //Escolhe um elemento qualquer da lista
       //Todos os elementos antes do pivô são menores que ele e os após a ele são maiores que ele
        while (i <= j) { 
            while (this.names.get(i).getLote().compareToIgnoreCase(pivot.getLote()) < 0) {
                i++;
            }

            while (this.names.get(j).getLote().compareToIgnoreCase(pivot.getLote()) > 0) {
                j--;
            }

            if (i <= j) {
                exchangeNames(i, j);
                i++;
                j--;
            }
        }
        //de forma recursiva ele vai ordenando, até que o pivô esteja realmente no meio do array
        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    }
void exchangeNames(int i, int j) { //Método que faz a troca dos nomes
        String temp = this.names.get(i).getLote();
        this.names.get(i).setLote(this.names.get(j).getLote()) ;
        this.names.get(j).setLote(temp);
    }
}
