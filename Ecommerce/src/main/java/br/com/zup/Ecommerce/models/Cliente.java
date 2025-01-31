package br.com.zup.Ecommerce.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do cliente é obrigatório.")
    private String nome;

    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos.")
    @Column(unique = true)
    private String cpf;

    @Email(message = "Email inválido.")
    @Column(unique = true)
    private String email;

    // Getters e Setters
}