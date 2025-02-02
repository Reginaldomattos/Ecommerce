package br.com.zup.ecommerce.services;

import br.com.zup.ecommerce.models.Produto;
import br.com.zup.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Produto cadastrarProduto(Produto produto) {
        validarProdutoDuplicado(produto.getNome());
        return produtoRepository.save(produto);
    }

    @Transactional
    public Produto realizarCompra(String nome, int quantidade) {
        Produto produto = buscarProdutoPorNome(nome);
        validarEstoqueSuficiente(produto, quantidade);
        atualizarEstoque(produto, quantidade);
        return produtoRepository.save(produto);
    }

    private void validarProdutoDuplicado(String nome) {
        if (produtoRepository.existsByNome(nome)) {
            throw new IllegalArgumentException("Produto com o mesmo nome já cadastrado.");
        }
    }

    private Produto buscarProdutoPorNome(String nome) {
        return produtoRepository.findByNome(nome)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado."));
    }

    private void validarEstoqueSuficiente(Produto produto, int quantidade) {
        if (produto.getQuantidade() < quantidade) {
            throw new IllegalArgumentException("Produto em falta no estoque.");
        }
    }

    private void atualizarEstoque(Produto produto, int quantidade) {
        produto.setQuantidade(produto.getQuantidade() - quantidade);
    }
}