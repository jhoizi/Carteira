package com.mercado.carteira.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CarteiraController {

    @RequestMapping("/calculadora")
    public String calculadora(){
        return "calculadora";
    }

    @RequestMapping("/listas")
    public String listas(){
        return "listas";
    }

}
