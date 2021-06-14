package com.estudo.tads.projeto.Controler;

import com.estudo.tads.projeto.Produto;
import com.estudo.tads.projeto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    public void setProdutoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @RequestMapping("/")
    public String getHome(Model model) {

        List<Produto> produtoLista = produtoService.findall();
        model.addAttribute("produtoLista", produtoLista);
        return "index";
    }

    @RequestMapping("/cadastrar")
    public String getCadastrar(Model model) {
        var produto = new Produto();
        model.addAttribute("produto", produto);
        return "cadastro";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String getSalvar(@ModelAttribute Produto produto) {
        produtoService.add(produto);
        return "redirect:/";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView getEditar(@PathVariable(name = "id") Long id) {

        var produto = produtoService.getOne(id);
        var modelAndView = new ModelAndView("editar");
        modelAndView.addObject("produto", produto);
        return modelAndView;
    }

    @RequestMapping("/deletar/{id}")
    public String getDeletar(@PathVariable(name = "id") Long id) {
        produtoService.delete(id);
        return "redirect:/";
    }

}
