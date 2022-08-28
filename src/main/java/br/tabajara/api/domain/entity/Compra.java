package br.tabajara.api.domain.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Compra {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    // select * from compra where idPEssoa = 2

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compra", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<ItemCompra> listaItens;

}
