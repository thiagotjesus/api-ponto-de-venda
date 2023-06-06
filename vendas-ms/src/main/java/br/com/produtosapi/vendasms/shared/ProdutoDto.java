package br.com.produtosapi.vendasms.shared;

public class ProdutoDto {
    private Integer id;
    private String nome;
    private Double valor;
    private Integer quantidadeEstoque;
    
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
    public void atualizarEstoque(Integer quantidadeVendida) {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
