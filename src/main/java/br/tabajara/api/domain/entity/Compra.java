package br.tabajara.api.domain.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Compra {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

}
