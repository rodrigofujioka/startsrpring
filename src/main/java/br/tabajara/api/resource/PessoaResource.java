package br.tabajara.api.resource;

import br.tabajara.api.domain.entity.Pessoa;
import br.tabajara.api.domain.repository.PessoaRepository;
import br.tabajara.api.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaService service;

    @PostMapping
    public ResponseEntity<Pessoa> incluir(@RequestBody Pessoa pessoa){
        Pessoa p = service.incluir(pessoa);
        return ResponseEntity.ok(p);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listar(){
        List<Pessoa> lista = service.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> consultarPorId(@PathVariable("id") Integer id){
        Pessoa pessoa = service.consultar(id);
        return ResponseEntity.ok(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPorId(@PathVariable("id") Integer id){
        service.excluir(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping
    public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa pessoa){

        if(Objects.isNull(pessoa.getId()) || !service.existsById(pessoa.getId())){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(service.atualizar(pessoa));
    }

}
