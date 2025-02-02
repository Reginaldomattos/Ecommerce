package br.com.zup.ecommerce.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Objects;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do cliente é obrigatório.")
    private String nome;

    @NotBlank(message = "O CPF é obrigatório.")
    @CPF(message = "O CPF é inválido.")
    @Column(unique = true)
    private String cpf;

    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O email é inválido.")
    @Column(unique = true)
    private String email;

    // Default constructor for JPA
    protected Cliente() {}

    // Constructor for creating new Cliente instances
    public Cliente(@NotBlank(message = "O nome do cliente é obrigatório.") String nome,
                   @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos.") String cpf,
                   @Email(message = "Email inválido.") String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    // No setters to enforce immutability. Use a builder or factory if updates are needed.

    @Override
    public String toString() {
        return String.format("Cliente{id=%d, nome='%s', cpf='%s', email='%s'}", id, nome, cpf, email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf) && Objects.equals(email, cliente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, email);
    }
}