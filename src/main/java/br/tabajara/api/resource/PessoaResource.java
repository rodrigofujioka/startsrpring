package br.tabajara.api.resource;

import br.tabajara.api.domain.entity.Pessoa;
import br.tabajara.api.domain.entity.dto.Errors;
import br.tabajara.api.domain.repository.PessoaRepository;
import br.tabajara.api.exceptions.GenericExceptionStart;
import br.tabajara.api.service.PessoaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;


@RestController
@Slf4j
@RequestMapping("/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaService service;

    @PostMapping
    public ResponseEntity incluir(@RequestBody  Pessoa pessoa){

        log.info("Incluir inicio" );
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        try{
            Set<ConstraintViolation<Pessoa>> violations = validator.validate(pessoa);
            if(violations.isEmpty()) {
                pessoa = service.incluir(pessoa);
            }else {
                List<String> listaViolations = new ArrayList<>();
                for(ConstraintViolation violation : violations){
                    String erro = violation.getPropertyPath()+ " : " + violation.getMessage();
                        listaViolations.add(erro);
                }
                log.error("Error Validation: Pessoa {}  error {}", pessoa, listaViolations);
                return ResponseEntity.badRequest().body(
                        Errors.builder()
                        .entity("Pessoa")
                        .error(listaViolations).build());
            }


        }catch (Exception e){
            log.error("Error: Pessoa {}  error {}", pessoa, e.getCause());
            throw new GenericExceptionStart(e.getMessage(), 400);
        }
        log.info("Incluir fim");
        return ResponseEntity.ok(pessoa);
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
