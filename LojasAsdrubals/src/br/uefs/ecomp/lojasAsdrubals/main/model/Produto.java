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
package br.uefs.ecomp.lojasAsdrubals.main.model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Abel Galvão / Francisco Tito
 */
public class Produto implements Comparable<Produto>{
    private String lote;
    private String endereco;
    private String bloco;
    private int numProduto;
    private String funcionario;
    private String data;
    private String hora;
    
    

    /**
     * Construtor Produto.
    */
    public Produto(String lote, String endereco, String bloco, int numProduto, String funcionario, String data, String hora) {
        this.lote = lote;
        this.endereco = endereco;
        this.bloco = bloco;
        this.numProduto = numProduto;
        this.funcionario = funcionario;
        this.data = data;
        this.hora = hora;
    }

    /**
     * Get lote.
     * @param lote - String 
    */
    public String getLote() {
        return lote;
    }

    /**
     * Set lote.
     * @param lote - String 
    */
    public void setLote(String lote) {
        this.lote = lote;
    }

    /**
     * Get endereco.
     * @param endereco - String 
    */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Set endereco.
     * @param endereco - String 
    */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Get bloco.
     * @param bloco - String 
    */
    public String getBloco() {
        return bloco;
    }

    /**
     * Set bloco.
     * @param bloco - String 
    */
    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    /**
     * Get numProduto.
     * @param numProduto - int 
    */
    public int getNumProduto() {
        return numProduto;
    }

    /**
     * Set numProduto.
     * @param numProduto - int 
    */
    public void setNumProduto(int numProduto) {
        this.numProduto = numProduto;
    }

    /**
     * Get funcionario.
     * @param funcionario - String 
    */
    public String getFuncionario() {
        return funcionario;
    }

    /**
     * Set funcionario.
     * @param funcionario - String 
    */
    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * Get data.
     * @param data - String
    */
    public String getData() {
        return data;
    }

    /**
     * Set data.
     * @param data - String
    */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Get hora.
     * @param hora - string
    */
    public String getHora() {
        return hora;
    }

    /**
     * Set hora.
     * @param hora - string
    */
    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public int compareTo(Produto o) {
        if(this.getLote().compareTo(o.getLote())<0 || this.getEndereco().compareTo(o.getEndereco())<0 || this.getBloco().compareTo(o.getBloco())<0 || this.getNumProduto()<o.getNumProduto() || this.getFuncionario().compareTo(o.getFuncionario())<0){
            return -1;
        }
        else if(this.getLote().compareTo(o.getLote())>0 || this.getEndereco().compareTo(o.getEndereco())>0 || this.getBloco().compareTo(o.getBloco())>0 || this.getNumProduto()>o.getNumProduto() || this.getFuncionario().compareTo(o.getFuncionario())>0){
            return 1;
        }
        else{
            return 0;
        }
        

    }

    /**
     * Método Mostra.
     * @param lote - String 
     * @param endereco - String
     * @param bloco - String 
     * @param numProduto - int
     * @param funcionario - String
     * @param data - String
     * @param hora - String
     * @return String - lote impresso na tela
     * @return String - endereco impresso na tela
     * @return String - bloco impresso na tela
     * @return int - numProduto impresso na tela
     * @return String - funcionario impresso na tela
     * @return Date - data impresso na tela
     * @return String - hora impresso na tela
     */
    public void Mostra() {
        System.out.println("---------------------");
        System.out.println("Lote " +this.getLote());
        System.out.println("Endereço " +this.getEndereco());
        System.out.println("Bloco " + this.getBloco());
        System.out.println("Num produto "+this.getNumProduto());
        System.out.println("Funcionario "+this.getFuncionario());
        System.out.println("Data "+this.getData());
        System.out.println("Hora "+this.getHora());
    }
    
    @Override
    public String toString() {
        return "Produto{" + "lote=" + lote + ", endereco=" + endereco + ", bloco=" + bloco + ", numProduto=" + numProduto + ", funcionario=" + funcionario + ", data=" + data + ", hora=" + hora + '}';
    }
    
    public String arquivo(){
            return ""+lote+";"+endereco+";"+bloco+";"+numProduto+";"+funcionario+";"+data+";"+hora;

}
}