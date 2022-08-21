package br.tabajara.api.resource;

import br.tabajara.api.domain.entity.Compra;
import br.tabajara.api.domain.entity.Produto;
import br.tabajara.api.service.CompraService;
import br.tabajara.api.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/produto")
public class CompraResource {

    private CompraService service;

    @PostMapping
    public ResponseEntity<Compra> incluir(Compra compra){
        return ResponseEntity.ok(service.incluir(compra));
    }

    @GetMapping
    public ResponseEntity<List<Compra>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @PutMapping
    public ResponseEntity<Compra> atualizar(Compra compra){
        return ResponseEntity.ok(service.atualizar(compra));
    }

}
