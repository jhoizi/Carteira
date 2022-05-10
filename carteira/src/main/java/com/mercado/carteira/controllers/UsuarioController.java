package com.mercado.carteira.controllers;

import com.mercado.carteira.models.LoginModel;
import com.mercado.carteira.models.UsuarioModel;
import com.mercado.carteira.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping("/cadastro")
    public String cadastro(){
        return "cadastro";
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public String cadastrar(UsuarioModel usuario){
        usuarioRepository.save(usuario);
        return "redirect:/";
    }

    @PostMapping(value="/login")
    public RedirectView logarUsuario(LoginModel login, HttpServletRequest request, RedirectAttributes attributes){
        UsuarioModel usuario = usuarioRepository.findByIdentificador(login.getIdentificador());
        if (usuario != null){
            if (usuario.getSenha().equals(login.getSenha())){
                attributes.addFlashAttribute("usuario", usuario);
                return new RedirectView("/carteira");
            }
        }
        RedirectView modeloErro = new RedirectView("login");
        attributes.addFlashAttribute("erro", "Login inválido! Confira os dados.");

        return modeloErro;
    }
}
