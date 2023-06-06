package br.com.produtosapi.vendasms.util;

public class QuantidadeInvalidaException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public QuantidadeInvalidaException(){
        super("A Quantidade vendida é maior do que a quantidade em estoque.");
    }

    public QuantidadeInvalidaException(String mensagem){
        super(mensagem);
    }
}
