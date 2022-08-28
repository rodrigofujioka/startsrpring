package br.tabajara.api.resource;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/home")
public class HomeResource {

    @GetMapping
    public String up(){
        return "Up " + new Date();
    }
}
