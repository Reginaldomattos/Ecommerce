package br.com.zup.ecommerce.controllers;

import br.com.zup.ecommerce.models.Produto;
import br.com.zup.ecommerce.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@Valid @RequestBody Produto produto) {
        Produto produtoCadastrado = produtoService.cadastrarProduto(produto);
        return ResponseEntity.ok(produtoCadastrado);
    }

    @PostMapping("/comprar")
    public ResponseEntity<Produto> realizarCompra(
            @RequestParam String nome,
            @RequestParam int quantidade) {
        Produto produtoComprado = produtoService.realizarCompra(nome, quantidade);
        return ResponseEntity.ok(produtoComprado);
    }
}