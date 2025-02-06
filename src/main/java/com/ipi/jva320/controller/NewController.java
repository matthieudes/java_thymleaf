package com.ipi.jva320.controller;

import com.ipi.jva320.exception.SalarieException;
import com.ipi.jva320.model.SalarieAideADomicile;
import com.ipi.jva320.service.SalarieAideADomicileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewController {
    @Autowired
    SalarieAideADomicileService salarieAideADomicileService;

    @GetMapping("/salaries/new")
    public String newSalarie(final ModelMap model) {
        model.addAttribute("salarie", new SalarieAideADomicile());
        return "detail_Salarie";
    }
    @PostMapping("/salaries/")
    public String saveSalarie(@ModelAttribute SalarieAideADomicile salarie) {
        try {
            salarieAideADomicileService.creerSalarieAideADomicile(salarie);
        } catch (SalarieException e) {
            return "redirect:/salaries/new?error=" + e.getMessage();
        }
        return "redirect:/salaries";
    }
}
