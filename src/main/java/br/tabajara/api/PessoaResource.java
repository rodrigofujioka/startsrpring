package br.tabajara.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

    @GetMapping
    public String home(){
        return " API de Pessoas";
    }

    @GetMapping("/idade")
    public String exibeIdadeProgramador(){
        return "Idade: 39";
    }

    @GetMapping("/nome")
    public String exibeNomeProgramador(){
        return "Nome: Rodrigo Fujioka";
    }

    @GetMapping("/idade/{idade}")
    public String verificaIdade(@PathVariable("idade") int idade){
        if(idade <18){
            return "Você não tem idade para beber";
        }else{
            return "Beba a vontade, que sorte grande";
        }
    }
}
