package br.tabajara.api.resource;

import br.tabajara.api.domain.entity.Compra;
import br.tabajara.api.domain.entity.Produto;
import br.tabajara.api.service.CompraService;
import br.tabajara.api.service.ProdutoService;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
import lombok.AllArgsConstructor;
>>>>>>> 0926a41543ea0b6e061d2eff8d7d3eceec674476
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
<<<<<<< HEAD
@RequestMapping("/compra")
public class CompraResource {

    @Autowired
    private CompraService service;

    @PostMapping
    public ResponseEntity<Compra> incluir(@RequestBody Compra compra){
=======
@AllArgsConstructor
@RequestMapping("/produto")
public class CompraResource {

    private CompraService service;

    @PostMapping
    public ResponseEntity<Compra> incluir(Compra compra){
>>>>>>> 0926a41543ea0b6e061d2eff8d7d3eceec674476
        return ResponseEntity.ok(service.incluir(compra));
    }

    @GetMapping
    public ResponseEntity<List<Compra>> listar(){
        return ResponseEntity.ok(service.listar());
    }

<<<<<<< HEAD
=======
    @PutMapping
    public ResponseEntity<Compra> atualizar(Compra compra){
        return ResponseEntity.ok(service.atualizar(compra));
    }

>>>>>>> 0926a41543ea0b6e061d2eff8d7d3eceec674476
}
