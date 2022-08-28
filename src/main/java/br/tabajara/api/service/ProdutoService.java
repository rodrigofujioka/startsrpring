package br.tabajara.api.service;

import br.tabajara.api.domain.entity.Produto;
import br.tabajara.api.domain.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {


    @Autowired
    private ProdutoRepository repository;

    public Produto incluir(Produto produto){
        return repository.save(produto);
    }
    public Produto consultar(Integer id){
        return repository.findById(id).orElseThrow();
    }
    public void excluir(Integer id){
        repository.deleteById(id);
    }

    public List<Produto> listar(){
        return repository.findAll();
    }

    public Produto atualizar(Produto produto){
        return repository.save(produto);
    }
}
