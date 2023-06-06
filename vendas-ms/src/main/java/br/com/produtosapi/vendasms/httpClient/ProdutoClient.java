package br.com.produtosapi.vendasms.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.produtosapi.vendasms.model.Produto;
import br.com.produtosapi.vendasms.shared.ProdutoDto;

@FeignClient("produtos")
public interface ProdutoClient {
    
    @RequestMapping(method= RequestMethod.GET, value="/produto/{id}")
    Produto obterProdutoPorId(@PathVariable Integer id);
    @RequestMapping(method= RequestMethod.PUT, value="/produto/{id}")
    void atualizarProduto(@PathVariable Integer id, @RequestBody ProdutoDto dto);

}
