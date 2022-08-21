package br.tabajara.api.service;

import br.tabajara.api.domain.entity.Pessoa;
import br.tabajara.api.domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PessoaService {

    private PessoaRepository repository;

    public Pessoa incluir(Pessoa pessoa){
        return repository.save(pessoa);
    }
    public Pessoa consultar(Integer id){
        return repository.findById(id).orElseThrow();
    }
    public void excluir(Integer id){
        repository.deleteById(id);
    }

    public List<Pessoa> listar(){
        return repository.findAll();
    }

    public Pessoa atualizar(Pessoa pessoa){
        return repository.save(pessoa);
    }

    public Boolean existsById(Integer id){
        return repository.existsById(id);
    }
}
