package br.com.produtosapi.produtosms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto", schema = "pdv")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double valor;
    @Column(name = "quantidade_estoque")
    private Integer quantidadeEstoque;

    public Produto() {
    }

    public Produto(Integer id, String nome, Double valor, Integer quantidadeEstoque) {
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
