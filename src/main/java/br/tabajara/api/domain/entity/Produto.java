package br.tabajara.api.domain.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Produto {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "Campo nome precisa ser preenchido")
    private String nome;
    private String tipo;
}
