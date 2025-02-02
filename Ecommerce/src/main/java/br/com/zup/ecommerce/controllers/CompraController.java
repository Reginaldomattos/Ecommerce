package br.com.zup.ecommerce.controllers;

import br.com.zup.ecommerce.models.Compra;
import br.com.zup.ecommerce.services.CompraService;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/compras")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @PostMapping
    public Compra realizarCompra(@RequestBody Map<String, Object>) compraRequest) {
        String cpf = (String) compraRequest.get("cpf");
        List<String> nomesProdutos = ((List<Map<String, String>>) compraRequest.get("produtos"))
                .stream()
                .map(produto -> produto.get("nome"))
                .collect(Collectors.toList());

        return compraService.realizarCompra((cpf, nomesProdutos));

    }
}
