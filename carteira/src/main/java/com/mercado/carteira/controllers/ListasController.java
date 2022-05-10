package com.mercado.carteira.controllers;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.mercado.carteira.models.*;
import com.mercado.carteira.repositories.AtivoRepository;
import com.mercado.carteira.repositories.ListaRepository;
import com.mercado.carteira.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/listas")
public class ListasController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ListaRepository listaRepository;

    @Autowired
    private AtivoRepository ativoRepository;

    @RequestMapping("/{codigo}")
    public ModelAndView listas(@PathVariable("codigo") int codigo){
        ModelAndView model = new ModelAndView("listas");
        UsuarioModel usuario = usuarioRepository.findByIdentificador(codigo);
        List<ListaAcompanhamentoModel> listas = listaRepository.findByUsuario(usuario);
        Map<Integer, List<AtivoModel>> ativos = new HashMap<>();
        for(ListaAcompanhamentoModel lista : listas){
            ativos.put(lista.getCodigo(), ativoRepository.findByLista(lista));
        }
        model.addObject("listas", listas);
        model.addObject("usuario", usuario);
        model.addObject("ativos", ativos);
        return model;
    }

    @RequestMapping("/{codigo}/nova")
    public RedirectView redirectNovaLista(@PathVariable("codigo") int codigo, RedirectAttributes attributes){
        RedirectView model = new RedirectView("novalista");
        UsuarioModel usuario = usuarioRepository.findByIdentificador(codigo);
        attributes.addFlashAttribute("usuario", usuario);
        return model;
    }

    @RequestMapping("/{codigo}/novalista")
    public ModelAndView novaLista(){
        ModelAndView model = new ModelAndView("nova_lista");
        return model;
    }

    @PostMapping("/{codigo}/novalista")
    public RedirectView salvarLista(@PathVariable("codigo") int codigo, ListaAcompanhamentoModel lista, RedirectAttributes attributes){
        RedirectView model = new RedirectView("/carteira");
        UsuarioModel usuario = usuarioRepository.findByIdentificador(codigo);
        lista.setUsuario(usuario);
        listaRepository.save(lista);
        attributes.addFlashAttribute("usuario", usuario);
        return model;
    }

    @RequestMapping("/{codigo}/{lista}")
    public ModelAndView lista(@PathVariable("lista") int codigoLista, @PathVariable("codigo") int codigoUsuario){
        ModelAndView model = new ModelAndView("lista_completa");
        ListaAcompanhamentoModel lista = listaRepository.findByCodigo(codigoLista);
        UsuarioModel usuario = usuarioRepository.findByIdentificador(codigoUsuario);
        List<AtivoModel> ativos = ativoRepository.findByLista(lista);
        model.addObject("lista", lista);
        model.addObject("usuario", usuario);
        model.addObject("ativos", ativos);
        return model;
    }

    @RequestMapping("/{codigo}/{lista}/novo")
    public RedirectView redirectNovoAtivo(@PathVariable("lista") int codigoLista, RedirectAttributes attributes){
        RedirectView model = new RedirectView("novoativo");
        ListaAcompanhamentoModel lista = listaRepository.findByCodigo(codigoLista);
        attributes.addFlashAttribute("lista", lista);
        return model;
    }

    @RequestMapping("/{codigo}/{lista}/remover")
    public RedirectView removerLista(@PathVariable("codigo") int codigoUsuario, @PathVariable("lista") int codigoLista, RedirectAttributes attributes){
        RedirectView model = new RedirectView("/carteira");
        ListaAcompanhamentoModel lista = listaRepository.findByCodigo(codigoLista);
        List<AtivoModel> ativos = ativoRepository.findByLista(lista);

        for(AtivoModel ativo: ativos){
            ativoRepository.delete(ativo);
        }
        listaRepository.delete(lista);

        UsuarioModel usuario = usuarioRepository.findByIdentificador(codigoUsuario);
        attributes.addFlashAttribute("usuario", usuario);
        return model;
    }

    @RequestMapping("/{codigo}/{lista}/{ativo}")
    public ModelAndView ativo(@PathVariable("lista") int codigoLista, @PathVariable("ativo") int codigoAtivo){
        ModelAndView model = new ModelAndView("ativo");
        ListaAcompanhamentoModel lista = listaRepository.findByCodigo(codigoLista);
        AtivoModel ativo = ativoRepository.findByCodigo(codigoAtivo);
        model.addObject("ativo", ativo);
        return model;
    }

    @RequestMapping("/{codigo}/{lista}/{ativo}/remover")
    public RedirectView ativo(@PathVariable("codigo") int codigoUsuario, @PathVariable("ativo") int codigoAtivo, RedirectAttributes attributes){
        RedirectView model = new RedirectView("/carteira");
        AtivoModel ativo = ativoRepository.findByCodigo(codigoAtivo);
        ativoRepository.delete(ativo);
        UsuarioModel usuario = usuarioRepository.findByIdentificador(codigoUsuario);
        attributes.addFlashAttribute("usuario", usuario);
        return model;
    }

    @RequestMapping("/{codigo}/{lista}/novoativo")
    public ModelAndView novoAtivo(HttpServletRequest request){
        ModelAndView model = new ModelAndView("novo_ativo");
        return model;
    }

    @PostMapping("/{codigo}/{lista}/novoativo")
    public RedirectView salvarAtivo(@PathVariable("codigo") int codigoUsuario, @PathVariable("lista") int codigoLista, AtivoModel ativo, RedirectAttributes attributes){
        RedirectView model = new RedirectView("/carteira");
        ListaAcompanhamentoModel lista = listaRepository.findByCodigo(codigoLista);
        ativo.setLista(lista);
        ativoRepository.save(ativo);
        UsuarioModel usuario = usuarioRepository.findByIdentificador(codigoUsuario);
        attributes.addFlashAttribute("usuario", usuario);
        return model;
    }

}
