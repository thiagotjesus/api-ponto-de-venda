package br.com.produtosapi.vendasms.service;

import java.util.List;
import java.util.Optional;

import br.com.produtosapi.vendasms.shared.VendaCompletoDto;
import br.com.produtosapi.vendasms.shared.VendaDto;
import br.com.produtosapi.vendasms.shared.VendaSemProdutoDto;

public interface VendasService {

    List<VendaSemProdutoDto> obterTodasVendas();

    Optional<VendaCompletoDto> obterVendaPorId(Integer id);

    VendaSemProdutoDto realizarVenda(VendaDto dto);

}
