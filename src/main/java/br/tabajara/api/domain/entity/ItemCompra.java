package br.tabajara.api.domain.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ItemCompra {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    @JsonBackReference
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
}
