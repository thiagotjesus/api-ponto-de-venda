package br.com.produtosapi.vendasms.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "venda", schema = "pdv")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "data_hora")
    private LocalDateTime dataHora;
    @Column(name = "quantidade_vendida")
    private Integer quantidadeVendida;
    @Column(name = "valor_total")
    private Double valorTotal; 
    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    //#region Getters and Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
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
    public void setValorTotal(Double valorProduto) {
        this.valorTotal = valorProduto * quantidadeVendida;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    //#endregion
}
