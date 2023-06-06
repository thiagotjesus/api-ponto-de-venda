package br.com.produtosapi.vendasms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.produtosapi.vendasms.service.VendasService;
import br.com.produtosapi.vendasms.shared.VendaCompletoDto;
import br.com.produtosapi.vendasms.shared.VendaDto;
import br.com.produtosapi.vendasms.shared.VendaSemProdutoDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("venda")
public class VendasController {
    @Autowired
    VendasService servico;

    @GetMapping
    public ResponseEntity<List<VendaSemProdutoDto>> obterTodasVendas(){
        return new ResponseEntity<>(servico.obterTodasVendas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaCompletoDto> obterVendaPorId(@PathVariable Integer id){
        Optional<VendaCompletoDto> venda = servico.obterVendaPorId(id);
        if (venda.isPresent()) {
            return new ResponseEntity<>(venda.get(), HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    @CircuitBreaker(name = "produtoPendente", fallbackMethod = "realizarVendaSemProduto")
    public ResponseEntity<VendaSemProdutoDto> realizarVenda(@RequestBody VendaDto dto){
        return new ResponseEntity<>(servico.realizarVenda(dto), HttpStatus.CREATED);
    }

    public ResponseEntity<String> realizarVendaSemProduto(Exception e){
        String retorno = "Serviço: produtos/produto/{id} está fora do ar no momento";
        return new ResponseEntity<>(retorno, HttpStatus.SERVICE_UNAVAILABLE);
    }

}
