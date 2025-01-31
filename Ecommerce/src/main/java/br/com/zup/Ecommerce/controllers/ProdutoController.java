package br.com.zup.Ecommerce.controllers;

import br.com.zup.Ecommerce.models.Produto;
import br.com.zup.Ecommerce.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@Valid @RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.cadastrarProduto(produto));
    }

    @PostMapping("/comprar")
    public ResponseEntity<Produto> realizarCompra(@RequestParam String nome, @RequestParam int quantidade) {
        return ResponseEntity.ok(produtoService.realizarCompra(nome, quantidade));
    }

}
