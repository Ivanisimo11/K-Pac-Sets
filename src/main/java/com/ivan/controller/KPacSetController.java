package com.ivan.controller;

import com.ivan.entity.K_Pac;
import com.ivan.entity.K_PacSet;
import com.ivan.service.K_PacService;
import com.ivan.service.K_PacSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class KPacSetController {

    @Autowired
    private K_PacSetService k_pacSetService;
    @Autowired
    private K_PacService k_pacService;
    private int setId;

    @RequestMapping("/set")
    public String showAllKPacesInSetById(@RequestParam("setId") int id, Model model) {
        setId = id;
        List<K_Pac> k_PacksInSet = k_pacSetService.getKPacsFromSetById(setId);
        List<K_Pac> k_PacksWhichCanBeAdded = k_pacService.getAllK_Paces();
        k_PacksWhichCanBeAdded.removeAll(k_PacksInSet);
        model.addAttribute("k_PacksInSet", k_PacksInSet);
        model.addAttribute("k_PacksWhichCanBeAdded", k_PacksWhichCanBeAdded);
        return "set";
    }

    @RequestMapping("/deleteKPacFromSet")
    public String deleteK_PacInSetById(@RequestParam("kPacId") int kPacId, Model model) {
        k_pacSetService.deleteKPacFromSet(kPacId);
        List<K_Pac> k_PacksInSet = k_pacSetService.getKPacsFromSetById(setId);
        List<K_Pac> k_PacksWhichCanBeAdded = k_pacService.getAllK_Paces();
        k_PacksWhichCanBeAdded.removeAll(k_PacksInSet);
        model.addAttribute("k_PacksInSet", k_PacksInSet);
        model.addAttribute("k_PacksWhichCanBeAdded", k_PacksWhichCanBeAdded);
        return "set";
    }

    @RequestMapping("/k_PacksWhichCanBeAdded")
    public String showK_PacksWhichCanBeAdded(Model model) {
        List<K_Pac> k_PacksInSet = k_pacSetService.getKPacsFromSetById(setId);
        List<K_Pac> k_PacksWhichCanBeAdded = k_pacService.getAllK_Paces();
        k_PacksWhichCanBeAdded.removeAll(k_PacksInSet);
        List<K_Pac> allK_Packs = k_pacSetService.getKPacsFromSetById(setId);
        model.addAttribute("all_k_paces", allK_Packs);
        model.addAttribute("k_PacksWhichCanBeAdded", k_PacksWhichCanBeAdded);
        return "set";
    }
    @RequestMapping("/addKPacToSet")
    public String addK_PacInSetById(@RequestParam("kPacId") int kPacId, Model model) {
        K_PacSet k_pacSet = new K_PacSet();
        k_pacSet.setId_k_pac(kPacId);
        k_pacSet.setId_set(setId);
        k_pacSetService.addKPacToSet(k_pacSet);
        List<K_Pac> k_PacksInSet = k_pacSetService.getKPacsFromSetById(setId);
        List<K_Pac> k_PacksWhichCanBeAdded = k_pacService.getAllK_Paces();
        k_PacksWhichCanBeAdded.removeAll(k_PacksInSet);
        model.addAttribute("k_PacksInSet", k_PacksInSet);
        model.addAttribute("k_PacksWhichCanBeAdded", k_PacksWhichCanBeAdded);
        return "set";
    }
    //исправь добавление в сеты,оно отображает то что не должно!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
}