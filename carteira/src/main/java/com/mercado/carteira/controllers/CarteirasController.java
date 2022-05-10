package com.mercado.carteira.controllers;


import com.mercado.carteira.models.AtivoModel;
import com.mercado.carteira.models.CarteiraModel;
import com.mercado.carteira.models.OperacaoModel;
import com.mercado.carteira.models.UsuarioModel;
import com.mercado.carteira.repositories.CarteiraRepository;
import com.mercado.carteira.repositories.OperacaoRepository;
import com.mercado.carteira.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/carteiras")
public class CarteirasController {

    @Autowired
    private CarteiraRepository carteiraRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private OperacaoRepository operacaoRepository;

    @RequestMapping("/{codigo}")
    public ModelAndView telaCarteiras(@PathVariable("codigo") int codigo){
        ModelAndView model = new ModelAndView("carteiras");
        UsuarioModel usuario = usuarioRepository.findByIdentificador(codigo);
        List<CarteiraModel> carteiras = carteiraRepository.findByUsuario(usuario);
        Map<Integer, List<OperacaoModel>> operacoes = new HashMap<>();
        for(CarteiraModel carteira : carteiras){
            operacoes.put(carteira.getCodigo(), operacaoRepository.findByCarteira(carteira));
        }
        model.addObject("carteiras", carteiras);
        model.addObject("usuario", usuario);
        model.addObject("operacoes", operacoes);
        return model;
    }

    @RequestMapping("/{codigo}/nova")
    public RedirectView redirectNovaCarteira(@PathVariable("codigo") int codigo, RedirectAttributes attributes){
        RedirectView model = new RedirectView("novacarteira");
        UsuarioModel usuario = usuarioRepository.findByIdentificador(codigo);
        attributes.addFlashAttribute("usuario", usuario);
        return model;
    }

    @RequestMapping("/{codigo}/novacarteira")
    public ModelAndView novaCarteira(@ModelAttribute("usuario") UsuarioModel usuario, HttpServletRequest request){
        ModelAndView model = new ModelAndView("nova_carteira");
        return model;
    }

    @PostMapping("/{codigo}/novacarteira")
    public RedirectView salvarCarteira(@PathVariable("codigo") int codigo, CarteiraModel carteira, RedirectAttributes attributes){
        UsuarioModel usuario = usuarioRepository.findByIdentificador(codigo);
        carteira.setUsuario(usuario);
        carteiraRepository.save(carteira);
        attributes.addFlashAttribute("usuario", usuario);
        return new RedirectView("/carteira");
    }

    @RequestMapping("/{codigo}/{carteira}")
    public ModelAndView carteira(@PathVariable("carteira") int codigoCarteira, @PathVariable("codigo") int codigoUsuario){
        ModelAndView model = new ModelAndView("carteira_completa");
        CarteiraModel carteira = carteiraRepository.findByCodigo(codigoCarteira);
        UsuarioModel usuario = usuarioRepository.findByIdentificador(codigoUsuario);
        List<OperacaoModel> operacoes = operacaoRepository.findByCarteira(carteira);
        model.addObject("carteira", carteira);
        model.addObject("usuario", usuario);
        model.addObject("operacoes", operacoes);
        return model;
    }

    @RequestMapping("/{codigo}/{carteira}/nova")
    public RedirectView redirectNovaOperacao(@PathVariable("carteira") int codigoCarteira, RedirectAttributes attributes){
        RedirectView model = new RedirectView("novaoperacao");
        CarteiraModel carteira = carteiraRepository.findByCodigo(codigoCarteira);
        attributes.addFlashAttribute("cateira", carteira);
        return model;
    }

    @RequestMapping("/{codigo}/{carteira}/remover")
    public RedirectView removerCarteira(@PathVariable("codigo") int codigoUsuario,@PathVariable("carteira") int codigoCarteira, RedirectAttributes attributes){
        RedirectView model = new RedirectView("/carteira");
        CarteiraModel carteira = carteiraRepository.findByCodigo(codigoCarteira);
        List<OperacaoModel> operacoes = (List<OperacaoModel>) operacaoRepository.findAll();
        for(OperacaoModel operacao : operacoes){
            operacaoRepository.delete(operacao);
        }
        carteiraRepository.delete(carteira);
        UsuarioModel usuario = usuarioRepository.findByIdentificador(codigoUsuario);
        attributes.addFlashAttribute("usuario", usuario);
        return model;
    }

    @RequestMapping("/{codigo}/{carteira}/{operacao}")
    public ModelAndView operacao(@PathVariable("operacao") int codigoOperacao){
        ModelAndView model = new ModelAndView("operacao");
        OperacaoModel operacao = operacaoRepository.findByCodigo(codigoOperacao);
        model.addObject("operacao", operacao);
        return model;
    }

    @RequestMapping("/{codigo}/{carteira}/{operacao}/remover")
    public RedirectView removerOperacao(@PathVariable("codigo") int codigoUsuario, @PathVariable("operacao") int codigoOperacao, RedirectAttributes attributes){
        RedirectView model = new RedirectView("/carteira");
        OperacaoModel operacao = operacaoRepository.findByCodigo(codigoOperacao);
        operacaoRepository.delete(operacao);
        UsuarioModel usuario = usuarioRepository.findByIdentificador(codigoUsuario);
        attributes.addFlashAttribute("usuario", usuario);
        return model;
    }

    @RequestMapping("/{codigo}/{carteira}/novaoperacao")
    public ModelAndView novaOperacao(HttpServletRequest request){
        ModelAndView model = new ModelAndView("nova_operacao");
        return model;
    }

    @PostMapping("/{codigo}/{carteira}/novaoperacao")
    public RedirectView salvarOperacao(@PathVariable("codigo") int codigoUsuario, @PathVariable("carteira") int codidoCarteira, OperacaoModel operacao, RedirectAttributes attributes){
        RedirectView model = new RedirectView("/carteira");
        CarteiraModel carteira = carteiraRepository.findByCodigo(codidoCarteira);
        operacao.setCarteira(carteira);
        operacaoRepository.save(operacao);
        UsuarioModel usuario = usuarioRepository.findByIdentificador(codigoUsuario);
        attributes.addFlashAttribute("usuario", usuario);
        return model;
    }

}
