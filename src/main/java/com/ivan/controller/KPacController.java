package com.ivan.controller;

import com.ivan.entity.K_Pac;
import com.ivan.service.K_PacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class KPacController {
    @Autowired
    private K_PacService k_pacService;

    @RequestMapping("/kpacs")
    public String showAllKPaces(Model model) {
        List<K_Pac> allK_Paces = k_pacService.getAllK_Paces();
        model.addAttribute("all_k_paces", allK_Paces);
        K_Pac k_pac = new K_Pac();
        model.addAttribute("kPac",k_pac);
        return "all-kpacs";
    }

    @RequestMapping("/saveKPac")
    public String saveKPac(@ModelAttribute("kPac") K_Pac k_pac,Model model) {
        k_pacService.createK_Pac(k_pac);
        List<K_Pac> allK_Paces = k_pacService.getAllK_Paces();
        model.addAttribute("all_k_paces", allK_Paces);

        return "/all-kpacs";
    }

    @RequestMapping("/deleteKPac")
    public String deleteKPac(@RequestParam("kPacId") int id,Model model) {
        k_pacService.deleteK_Pac(id);
        K_Pac k_pac = new K_Pac();
        model.addAttribute("kPac",k_pac);
        List<K_Pac> allK_Paces = k_pacService.getAllK_Paces();
        model.addAttribute("all_k_paces", allK_Paces);
        return "/all-kpacs";
    }
}
