package com.ipi.jva320.controller;

import com.ipi.jva320.model.SalarieAideADomicile;
import com.ipi.jva320.service.SalarieAideADomicileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SalarieController {
    @Autowired
    private SalarieAideADomicileService salarieAideADomicileService;


    @GetMapping("/salaries")
    public String salaries(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "10") int size,
                           @RequestParam(required = false) String nom,
                           ModelMap model) {
        if (nom != null && !nom.isEmpty()) {
            List<SalarieAideADomicile> salarie = salarieAideADomicileService.getSalaries(nom);
            model.put("salaries", salarie);
            model.put("currentPage", 0);
            model.put("totalPages", 1);
        } else {
            Page<SalarieAideADomicile> salariesPage = salarieAideADomicileService.getSalaries(PageRequest.of(page, size));
            model.addAttribute("salaries", salariesPage.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", salariesPage.getTotalPages());
            model.addAttribute("totalSalaries", salariesPage.getTotalElements());
        }

        return "list";
    }



}
