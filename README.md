# Sistema de E-Commerce

Este é um sistema básico de E-Commerce desenvolvido em Java com Spring Boot. Ele permite o cadastro de produtos, clientes e a realização de compras, simulando o funcionamento de uma loja virtual.

## Funcionalidades

- **
Cadastro de Produtos
**:
  - Nome (único e obrigatório).
  - Preço (deve ser maior que 0).
  - Quantidade (deve ser maior ou igual a 0).

- **
Cadastro de Clientes
**:
  - Nome (obrigatório).
  - CPF (único, válido e obrigatório).
  - Email (único, válido e obrigatório).

- **
Realização de Compras
**:
  - Identificação do cliente pelo CPF.
  - Registro da compra no sistema.
  - Atualização da quantidade de produtos no estoque.

## Tecnologias Utilizadas

- **
Java 17
**
- **
Spring Boot
**
  - Spring Web
  - Spring Data JPA
  - Spring Validation
- **
Banco de Dados H2
** (em memória)
- **
Maven
** (gerenciador de dependências)

## Pré-requisitos

- **
Java 17
** ou superior instalado.
- **
Maven
** instalado.

## Configuração do Banco de Dados

O sistema utiliza o banco de dados H2 em memória. As configurações estão no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:ecommerce
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
