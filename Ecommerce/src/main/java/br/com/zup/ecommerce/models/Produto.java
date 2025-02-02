package br.com.zup.ecommerce.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do produto é obrigatório.")
    @Column(unique = true, nullable = false)
    private String nome;

    @Min(value = 0, message = "O preço deve ser maior ou igual a 0.")
    @Column(nullable = false)
    private double preco;

    @Min(value = 0, message = "A quantidade deve ser maior ou igual a 0.")
    @Column(nullable = false)
    private int quantidade;

    // Default constructor for JPA
    protected Produto() {
    }

    // Constructor with parameters
    public Produto(String nome, double preco, int quantidade) {
        validateInputs(nome, preco, quantidade);
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Business logic methods
    public void atualizarPreco(double novoPreco) {
        if (novoPreco < 0) {
            throw new IllegalArgumentException("O preço deve ser maior ou igual a 0.");
        }
        this.preco = novoPreco;
    }

    public void atualizarQuantidade(int novaQuantidade) {
        if (novaQuantidade < 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior ou igual a 0.");
        }
        this.quantidade = novaQuantidade;
    }

    // Utility methods
    private void validateInputs(String nome, double preco, int quantidade) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do produto é obrigatório.");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("O preço deve ser maior ou igual a 0.");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior ou igual a 0.");
        }
    }

    @Override
    public String toString() {
        return String.format("Produto{id=%d, nome='%s', preco=%.2f, quantidade=%d}", id, nome, preco, quantidade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Double.compare(produto.preco, preco) == 0 &&
                quantidade == produto.quantidade &&
                Objects.equals(id, produto.id) &&
                Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, preco, quantidade);
    }

    public void setQuantidade(int i) {
    }
}