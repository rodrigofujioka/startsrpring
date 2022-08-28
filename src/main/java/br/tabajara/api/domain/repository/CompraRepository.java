package br.tabajara.api.domain.repository;

import br.tabajara.api.domain.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra,Integer> {


    List<Compra> findByPessoaId(Integer id);

    @Query("select c from Compra c where c.pessoa.id =:id ")
    List<Compra> listarPorPessoaID(@Param("id") Integer id);

    @Query(value = "select * from compra where pessoa_id =:id "
            , nativeQuery = true)
    List<Integer> listarIdCompraPorPessoa(@Param("id") Integer id);

}
