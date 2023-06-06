package br.com.produtosapi.produtosms.service;

import java.util.List;

import java.util.Optional;

import br.com.produtosapi.produtosms.shared.ProdutoDto;

public interface ProdutoService {

    List<ProdutoDto> obterTodosProdutos();

    Optional<ProdutoDto> obterProdutoPorId(Integer id);

    ProdutoDto cadastrarProduto(ProdutoDto dto);

    void deletarProduto(Integer id);

    Optional<ProdutoDto> atualizarProduto(Integer id, ProdutoDto dto);

}
