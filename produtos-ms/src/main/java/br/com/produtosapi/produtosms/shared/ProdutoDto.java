package br.com.produtosapi.produtosms.shared;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public class ProdutoDto {
    private Integer id;
    @NotEmpty(message = "O nome precisa ser informado")
    private String nome;
    @Positive(message = "O valor deve ser informado")
    private Double valor;
    @Positive(message = "O valor deve ser informado")
    private Integer quantidadeEstoque;
    
    public ProdutoDto() {
    }

    public ProdutoDto(Integer id, String nome, Double valor, Integer quantidadeEstoque) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    //#region Getters and Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    //#endregion
}
