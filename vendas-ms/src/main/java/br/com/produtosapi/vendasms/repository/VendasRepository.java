package br.com.produtosapi.vendasms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.produtosapi.vendasms.model.Venda;

public interface VendasRepository extends JpaRepository<Venda, Integer>{
    
}
