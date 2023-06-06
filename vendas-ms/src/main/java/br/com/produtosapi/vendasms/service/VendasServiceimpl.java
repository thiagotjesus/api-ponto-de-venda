package br.com.produtosapi.vendasms.service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.produtosapi.vendasms.httpClient.ProdutoClient;
import br.com.produtosapi.vendasms.model.Produto;
import br.com.produtosapi.vendasms.model.Venda;
import br.com.produtosapi.vendasms.repository.VendasRepository;
import br.com.produtosapi.vendasms.shared.ProdutoDto;
import br.com.produtosapi.vendasms.shared.VendaCompletoDto;
import br.com.produtosapi.vendasms.shared.VendaDto;
import br.com.produtosapi.vendasms.shared.VendaSemProdutoDto;
import br.com.produtosapi.vendasms.util.QuantidadeInvalidaException;

@Service
public class VendasServiceimpl implements VendasService{

    @Autowired
    private VendasRepository repositorio;

    @Autowired
    ProdutoClient cliente;

    @Override
    public List<VendaSemProdutoDto> obterTodasVendas() {
        return repositorio.findAll().stream()
        .map(v -> {
            VendaSemProdutoDto dto = new ModelMapper().map(v, VendaSemProdutoDto.class);
            dto.setIdProduto(v.getProduto().getId());
            return dto;
        }).collect(toList());
    }

    @Override
    public Optional<VendaCompletoDto> obterVendaPorId(Integer id) {

        Optional<Venda> venda = repositorio.findById(id);
        if (venda.isPresent()) {
            return Optional.of(new ModelMapper().map(venda, VendaCompletoDto.class));
        }
        return Optional.empty();
    }

    @Override
    public VendaSemProdutoDto realizarVenda(VendaDto dto) {
        Produto produto = cliente.obterProdutoPorId(dto.getIdProduto());
        if (produto.getQuantidadeEstoque() < dto.getQuantidadeVendida()) {
            throw new QuantidadeInvalidaException();
        }
        produto.atualizarEstoque(dto.getQuantidadeVendida());
        cliente.atualizarProduto(dto.getIdProduto(), new ModelMapper().map(produto, ProdutoDto.class));
        Venda venda = new Venda();
        venda.setDataHora(LocalDateTime.now());
        venda.setQuantidadeVendida(dto.getQuantidadeVendida());
        venda.setValorTotal(produto.getValor());
        venda.setProduto(produto);
        repositorio.save(venda);
        VendaSemProdutoDto retornoVenda = new ModelMapper().map(venda, VendaSemProdutoDto.class);
        retornoVenda.setIdProduto(venda.getProduto().getId());
        return retornoVenda;
    }
}