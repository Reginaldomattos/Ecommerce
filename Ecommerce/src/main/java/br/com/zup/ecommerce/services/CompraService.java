package br.com.zup.ecommerce.services;

import br.com.zup.ecommerce.repository.ClienteRepository;
import br.com.zup.ecommerce.repository.CompraRepository;
import br.com.zup.ecommerce.repository.ProdutoRepository;

import java.util.List;

public class CompraService {

    private ClienteRepository clienteRepository;

    private ProdutoRepository produtoRepository;

    private CompraRepository compraRepository;

    public Compra realizarCompra(String cpf, List<String> nomesProdutos) {

    }
}
