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

/**
 *
 * @author Abel Galvão / Francisco Tito
 */
public class ErroChaveException extends Exception{
    /**
     * Metodo de Erro de chave.
     * @param mensagem - String
     * @return mensagem de erro
    */
    public ErroChaveException(String mensagem){
        super(mensagem);
    }
    
    /**
     * Metodo de Erro de chave.
     * @param exe - Throwable
    */
    public ErroChaveException(Throwable exc){
        super(exc);
    }
}
