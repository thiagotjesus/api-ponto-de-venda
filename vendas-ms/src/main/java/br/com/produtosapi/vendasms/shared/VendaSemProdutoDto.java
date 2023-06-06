package br.com.produtosapi.vendasms.shared;

public class VendaSemProdutoDto {
    private Integer id;
    private String dataHora;
    private Integer quantidadeVendida;
    private Double valorTotal; 
    private Integer idProduto;
    
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
    public Integer getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

}
