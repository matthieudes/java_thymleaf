package com.ipi.jva320.controller;

import com.ipi.jva320.exception.SalarieException;
import com.ipi.jva320.model.SalarieAideADomicile;
import com.ipi.jva320.service.SalarieAideADomicileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DetailController {
    @Autowired
    SalarieAideADomicileService salarieAideADomicileService;

    @GetMapping("/salaries/{id}")
    public String salarie(@PathVariable Long id, final ModelMap model)
    {
        SalarieAideADomicile salarie = salarieAideADomicileService.getSalarie(id);
        model.addAttribute("salarie", salarie);
        return "detail_Salarie";
    }
    @PostMapping("/salaries/{id}")
    public String updateSalarie( @ModelAttribute SalarieAideADomicile salarie) {
        try {
            salarieAideADomicileService.updateSalarieAideADomicile(salarie);
        } catch (Exception e) {
            return "redirect:/salaries/?error=" + e.getMessage();
        }
        return "redirect:/salaries";
    }

    @GetMapping("/salaries/{id}/delete")
    public String deleteSalarie(@PathVariable Long id) {
        try {
            salarieAideADomicileService.deleteSalarieAideADomicile(id);
        }catch (SalarieException e){
            System.out.println("SalarieException" + e.getMessage());
        }
        return "redirect:/salaries";
    }

}
