package br.com.zup.Ecommerce.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do produto é obrigatório.")
    @Column(unique = true)
    private String nome;

    @Min(value = 0, message = "O preço deve ser maior que 0.")
    private double preco;

    @Min(value = 0, message = "A quantidade deve ser maior ou igual a 0.")
    private int quantidade;

    // Getters e Setters
}