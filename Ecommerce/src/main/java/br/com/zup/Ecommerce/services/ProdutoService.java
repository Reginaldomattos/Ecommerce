package br.com.zup.Ecommerce.services;

import br.com.zup.Ecommerce.models.Produto;
import br.com.zup.Ecommerce.repository.ProdutoRepository;

public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public Produto cadastrarProduto(Produto produto) {
        if (produtoRepository.existsByNome(produto.getNome())) {
            throw new IllegalArgumentException("Produto com o mesmo nome já cadastrado.");
        }
        return produtoRepository.save(produto);
    }

    public Produto realizarCompra(String nome, int quantidade) {
        Produto produto = produtoRepository.findByNome(nome).orElseThrow(() -> IllegalArgumentException("Produto não encontrado."));
        if (produto.getQuantidade() < quantidade) {
            throw new IllegalArgumentException("Produto em falta no estoque.");
        }
        produto.setQuantidade(produto.getQuantidade() - quantidade);
        return produtoRepository.save(produto);
    }
}
