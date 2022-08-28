package br.tabajara.api.domain.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "Campo nome precisa ser preenchido")
    private String nome;
    private String tipo;
}
