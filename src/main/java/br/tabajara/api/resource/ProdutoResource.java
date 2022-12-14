package br.tabajara.api.resource;

import br.tabajara.api.domain.entity.Produto;
import br.tabajara.api.service.ProdutoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<Produto> incluir(@RequestBody Produto produto){
        return ResponseEntity.ok(service.incluir(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar(){
        return ResponseEntity.ok(service.listar());
    }

}
