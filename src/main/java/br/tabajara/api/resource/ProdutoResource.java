package br.tabajara.api.resource;

import br.tabajara.api.domain.entity.Produto;
import br.tabajara.api.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/produto")
public class ProdutoResource {

    private ProdutoService service;

    @PostMapping
    public ResponseEntity<Produto> incluir(Produto produto){
        return ResponseEntity.ok(service.incluir(produto));
    }

    @PostMapping
    public ResponseEntity<List<Produto>> listar(){
        return ResponseEntity.ok(service.listar());
    }

}
