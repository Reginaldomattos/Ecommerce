package br.com.zup.ecommerce.repository;

import br.com.zup.ecommerce.models.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}
