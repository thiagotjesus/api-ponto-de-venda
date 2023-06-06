package br.com.produtosapi.produtosms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.produtosapi.produtosms.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    List<Produto> findByOrderByNomeAsc();
    
}
