package br.tabajara.api.service;

import br.tabajara.api.domain.entity.Compra;
import br.tabajara.api.domain.entity.ItemCompra;
import br.tabajara.api.domain.entity.Produto;
import br.tabajara.api.domain.repository.CompraRepository;
import br.tabajara.api.domain.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class CompraService {

    @Autowired
    private CompraRepository repository;

    public Compra incluir(Compra compra){
        List<ItemCompra> lista = compra.getListaItens();
        compra.setListaItens(null);
        compra = repository.save(compra);

        for(ItemCompra item : lista){
            item.setCompra(compra);
        }
        compra.setListaItens(lista);
        return repository.save(compra);
    }
    public Compra consultar(Integer id){
        return repository.findById(id).orElseThrow();
    }
    public void excluir(Integer id){
        repository.deleteById(id);
    }

    public List<Compra> listar(){
        return repository.findAll();
    }

    public Compra atualizar(Compra compra){
        return repository.save(compra);
    }
}
