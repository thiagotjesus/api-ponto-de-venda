package br.com.produtosapi.produtosms.service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import br.com.produtosapi.produtosms.model.Produto;
import br.com.produtosapi.produtosms.repository.ProdutoRepository;
import br.com.produtosapi.produtosms.shared.ProdutoDto;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired 
    ProdutoRepository repositorio;

    @Override
    public List<ProdutoDto> obterTodosProdutos() {
        return repositorio.findByOrderByNomeAsc().stream()
        .map(p -> new ModelMapper().map(p, ProdutoDto.class))
        .collect(toList());
    }

    @Override
    public Optional<ProdutoDto> obterProdutoPorId(Integer id) {
        Optional<Produto> produto = repositorio.findById(id);

        if (produto.isPresent()) {
            return Optional.of(new ModelMapper().map(produto, ProdutoDto.class));
        }

        return Optional.empty();
    }

    @Override
    public ProdutoDto cadastrarProduto(ProdutoDto dto) {
        Produto produto = new ModelMapper().map(dto, Produto.class);
        repositorio.save(produto);
        return new ModelMapper().map(produto, ProdutoDto.class);
    }


    @Override
    public void deletarProduto(Integer id) {
        repositorio.deleteById(id);
    }

    @Override
    public Optional<ProdutoDto> atualizarProduto(Integer id, ProdutoDto dto) {
        Optional<Produto> produto = repositorio.findById(id);

        if (produto.isPresent()) {
            Produto produtoRetorno = new ModelMapper().map(dto, Produto.class);
            produtoRetorno.setId(id);
            repositorio.save(produtoRetorno);
            return Optional.of(new ModelMapper().map(produtoRetorno, ProdutoDto.class));
        }

        return Optional.empty();
    }
    
}
