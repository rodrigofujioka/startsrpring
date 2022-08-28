package br.tabajara.api.resource;

import br.tabajara.api.domain.entity.Compra;
import br.tabajara.api.domain.entity.Produto;
import br.tabajara.api.service.CompraService;
import br.tabajara.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")
public class CompraResource {

    @Autowired
    private CompraService service;

    @PostMapping
    public ResponseEntity<Compra> incluir(@RequestBody Compra compra){
        return ResponseEntity.ok(service.incluir(compra));
    }

    @GetMapping
    public ResponseEntity<List<Compra>> listar(){
        return ResponseEntity.ok(service.listar());
    }

}
