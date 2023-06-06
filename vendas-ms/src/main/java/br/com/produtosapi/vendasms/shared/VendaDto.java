package br.com.produtosapi.vendasms.shared;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class VendaDto {
    @NotNull
    private Integer idProduto;
    @Positive(message="A quantidade deve ser informada")
    private Integer quantidadeVendida;
    
    public Integer getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }
    public Integer getQuantidadeVendida() {
        return quantidadeVendida;
    }
    public void setQuantidadeVendida(Integer quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }
}
