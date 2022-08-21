package br.tabajara.api.domain.repository;

import br.tabajara.api.domain.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra,Integer> {
}
