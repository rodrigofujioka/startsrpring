package br.tabajara.api.service;

import br.tabajara.api.domain.entity.Compra;
import br.tabajara.api.domain.entity.Produto;
import br.tabajara.api.domain.repository.CompraRepository;
import br.tabajara.api.domain.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompraService {

   private CompraRepository repository;

    public Compra incluir(Compra compra){
        return repository.save(compra);
    }
    public Compra consultar(Integer id){
        return repository.findById(id).orElseThrow();
    }
    public void excluir(Integer id){
        repository.deleteById(id);
    }

    public List<Compra> listar(Compra produto){
        return repository.findAll();
    }

    public Compra atualizar(Compra compra){
        return repository.save(compra);
    }
}
