package br.com.zup.ecommerce.services;

import br.com.zup.ecommerce.models.Cliente;
import br.com.zup.ecommerce.models.Compra;
import br.com.zup.ecommerce.models.Produto;
import br.com.zup.ecommerce.repository.ClienteRepository;
import br.com.zup.ecommerce.repository.CompraRepository;
import br.com.zup.ecommerce.repository.ProdutoRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CompraService {

    private ClienteRepository clienteRepository;

    private ProdutoRepository produtoRepository;

    private CompraRepository compraRepository;

    public Compra realizarCompra(String cpf, List<String> nomesProdutos) {
        Cliente cliente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));

        List<Produto> produtos = new ArrayList<>();
        for (String nome : nomesProdutos) {
            Produto produto = produtoRepository.findByNome(nome)
                    .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado: " + nome));
            if (produto.getQuantidade() <= 0) {
                throw new IllegalArgumentException("Produto sem estoque: " + nome);
            }
            produto.setQuantidade(produto.getQuantidade() - 1);
            produtos.add(produto);
        }

        produtoRepository.saveAll(produtos);

        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.setProdutos(produtos);
        compra.setDataCompra(LocalDateTime.now());

        return compraRepository.save(compra);

    }
}
