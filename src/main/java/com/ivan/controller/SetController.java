package com.ivan.controller;

import com.ivan.entity.Set;
import com.ivan.service.SetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SetController {

    @Autowired
    private SetService setService;

    @RequestMapping("/sets")
    public String showAllSets(Model model) {
        List<Set> allSets = setService.getAllSets();
        model.addAttribute("all_sets", allSets);
        Set set = new Set();
        model.addAttribute("set", set);
        return "/all-sets";
    }

    @RequestMapping("/saveSet")
    public String saveSet(@ModelAttribute("set") Set set, Model model) {
        setService.createSet(set);
        List<Set> allSets = setService.getAllSets();
        model.addAttribute("all_sets", allSets);
        return "/all-sets";
    }

    @RequestMapping("/deleteSet")
    public String deleteSet(@RequestParam("setId") int id, Model model) {
        setService.deleteSet(id);
        Set set = new Set();
        model.addAttribute("set", set);
        List<Set> allSets = setService.getAllSets();
        model.addAttribute("all_sets", allSets);
        return "/all-sets";
    }
}
