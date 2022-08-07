package br.tabajara.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("")
public class HomeResource {

    @GetMapping
    public String up(){
        return "Up " + new Date();
    }
}
