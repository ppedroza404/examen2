package com.examen.exameniiv2.controller;

import com.examen.exameniiv2.domain.Futbolista;
import com.examen.exameniiv2.service.FutbolistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FutbolistaController {

    @Autowired
    FutbolistaService futbolistaService;

    @RequestMapping("/")
    private String homePage(Model model){
        return "index";
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("allPlayersList", futbolistaService.getAllFutbolistas());
        return "index";
    }

    @GetMapping("/viewhistorial/")
    public String viewHistory( Model model) {
        model.addAttribute("futbolista",futbolistaService.getHistorial());
        return "Historial";
    }

    @RequestMapping(value = "/registrar", method = RequestMethod.GET)
    public String addNewEmployee(Model model) {
        Futbolista futbolista = new Futbolista();
        model.addAttribute("futbolista", futbolista);
        return "registrar";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("futbolista") Futbolista futbolista) {
        futbolistaService.save(futbolista);
        return "redirect:/";
    }

    @PostMapping("/back")
    public String backFut(@ModelAttribute("futbolista") Futbolista futbolista) {
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        Futbolista futbolista = futbolistaService.getFutbolistaById(id);
        model.addAttribute("futbolista", futbolista);
        return "update";
    }
    @GetMapping("/view/{id}")
    public String viewform(@PathVariable(value = "id") long id, Model model) {
        Futbolista futbolista = futbolistaService.getFutbolistaById(id);
        model.addAttribute("futbolista", futbolista);
        return "view";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        futbolistaService.deleteViaId(id);
        return "redirect:/";

    }

    @RequestMapping(value="/aprox/{aproximador}", method=RequestMethod.POST)
    public String aproxFut(@RequestParam("textcontain") String aproximador, Model model) {
       model.addAttribute("allPlayersList", futbolistaService.aproxFutbolista(aproximador));
        return "aproxNyA";
    }
    @RequestMapping("/datosAprox")
    public String buscarFut() {
        return "pedirDatos";
    }

}
