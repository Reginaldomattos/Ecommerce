package br.com.zup.ecommerce.controllers;

import br.com.zup.ecommerce.models.Cliente;
import br.com.zup.ecommerce.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente salvar(@RequestBody @Valid Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @GetMapping("/{cpf}")
    public Cliente buscarPorCpf(@PathVariable String cpf) {
        return clienteService.buscarPorCpf(cpf);
    }
}