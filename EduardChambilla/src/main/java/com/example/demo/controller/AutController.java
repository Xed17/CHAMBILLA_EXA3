package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Aut;
import com.example.demo.service.AutService;

import jakarta.validation.Valid;

@Controller
public class AutController {
	@Autowired
    private AutService autService;
    
    @GetMapping
    public String index(Model model){
        model.addAttribute("autores", autService.readAll());
        return "index";
    }
    
    @GetMapping("/add")
    public String addAut(Model model){
        Aut aut = new Aut();
        model.addAttribute("aut", aut);
        return "add";
    }
    
    
    @GetMapping("/edit/{id}")
    public String editAut(@PathVariable("id") int id, Model model){
        model.addAttribute("aut", autService.read(id));
        return "edit";
    }
    
    @GetMapping("/del/{id}")
    public String delAut(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes){
    	autService.delete(id);
        redirectAttributes.addFlashAttribute("flashMessage", "Autor deleted Successfull");
        return "redirect:/";
    }
    @PostMapping("/save")
    public String savePost(@Valid Aut aut, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "add";
        }
        autService.create(aut);
        return "redirect:/";
    }
    @PostMapping("update/{id}")
    public String updateAut(@PathVariable("id") int id, @Valid Aut aut, BindingResult result, Model model) {
        if (result.hasErrors()) {            
            return "edit";
        }
        Aut auts = autService.read(id);
        auts.setId(id);
        auts.setNombres(aut.getNombres());
        auts.setApellidos(aut.getApellidos());
        auts.setPais(aut.getPais());
        auts.setEstado(aut.getEstado());
     autService.update(auts);
        model.addAttribute("autores", autService.readAll());
        return "index";
    }
}
