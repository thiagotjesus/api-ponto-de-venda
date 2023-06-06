package br.com.produtosapi.produtosms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import br.com.produtosapi.produtosms.service.ProdutoService;
import br.com.produtosapi.produtosms.shared.ProdutoDto;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    @Autowired
    ProdutoService servico;

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> obterTodosProdutos(){
        return new ResponseEntity<>(servico.obterTodosProdutos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> obterProdutoPorId(@PathVariable Integer id){
        Optional<ProdutoDto> produto = servico.obterProdutoPorId(id);
        if (produto.isPresent()) {
            return new ResponseEntity<>(produto.get(), HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<ProdutoDto> cadastrarProduto(@RequestBody ProdutoDto dto){
        return new ResponseEntity<>(servico.cadastrarProduto(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Integer id){
        servico.deletarProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDto> atualizarProduto(@PathVariable Integer id, @RequestBody ProdutoDto dto){
        Optional<ProdutoDto> produto = servico.atualizarProduto(id, dto);
        if (produto.isPresent()) {
            return new ResponseEntity<>(produto.get(), HttpStatus.ACCEPTED);
        }
            
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
