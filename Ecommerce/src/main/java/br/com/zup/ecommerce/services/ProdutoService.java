package br.com.zup.ecommerce.services;

import br.com.zup.ecommerce.models.Produto;
import br.com.zup.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto salvar(Produto produto) {
        if (produtoRepository.findByNome(produto.getNome()).isPresent()) {
            throw new IllegalArgumentException("Produto com o mesmo nome já existe.");
        }
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}