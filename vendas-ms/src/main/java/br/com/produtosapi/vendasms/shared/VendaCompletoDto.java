package br.com.produtosapi.vendasms.shared;

public class VendaCompletoDto {
    private Integer id;
    private String dataHora;
    private Integer quantidadeVendida;
    private Double valorTotal; 
    private ProdutoDto produto;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDataHora() {
        return dataHora;
    }
    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
    public Integer getQuantidadeVendida() {
        return quantidadeVendida;
    }
    public void setQuantidadeVendida(Integer quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }
    public Double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public ProdutoDto getProduto() {
        return produto;
    }
    public void setProduto(ProdutoDto produto) {
        this.produto = produto;
    }
}
