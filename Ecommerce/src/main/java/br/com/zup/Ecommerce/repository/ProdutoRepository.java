package br.com.zup.Ecommerce.repository;

public interface ProdutoRepository extends JpaRepository<Produto, long> {
    boolean existsByNome(String nome);
}
