package com.ipi.jva320.controller;

import com.ipi.jva320.service.SalarieAideADomicileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalarieController {
    @Autowired
    private SalarieAideADomicileService salarieAideADomicileService;


    @GetMapping("/salaries")
    public String salaries(final ModelMap model) {

        model.addAttribute("salaries", salarieAideADomicileService.getSalaries());
        return "list";
    }

}
