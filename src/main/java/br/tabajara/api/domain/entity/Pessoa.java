package br.tabajara.api.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "nome", length = 200)
    private String nome;
    private int idade;
    private String sexo;
    private String cidade;
    @Email(message = "E-mail não é válido, preencha com informações corretas")
    private String email;

    @Transient
    private List<String> violations;
}
