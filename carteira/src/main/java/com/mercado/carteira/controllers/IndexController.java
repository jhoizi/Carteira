package com.mercado.carteira.controllers;

import com.mercado.carteira.models.UsuarioModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
/*
    @RequestMapping("/carteira")
    public ModelAndView carteira(){
        System.out.println(usuario.getIdentificador());
        ModelAndView model = new ModelAndView("carteira");
        model.addObject("usuario", usuario);
        return model;
    }
*/
    @RequestMapping("/carteira")
    public String carteira(@ModelAttribute("usuario") UsuarioModel usuario, HttpServletRequest request){

        return "carteira";
    }
}
