package com.etu.crm.demo.controller;

import com.etu.crm.demo.dto.OrgFormDTO;
import com.etu.crm.demo.mapper.OrganisationMapper;
import com.etu.crm.demo.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    private final OrganisationService organisationService;

    @Autowired
    public MainController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @GetMapping("/")
    public String getAllOrganisation(Model model){
        model.addAttribute("orgs",organisationService.getAllOrganisation());
        return "index";
    }

    @GetMapping("/show/{name}")
    public String showOrg(Model model, @PathVariable String name){
        model.addAttribute("org",organisationService.getOne(name).orElseThrow(RuntimeException::new));
        return "show";
    }

    @GetMapping("/edit/{name}")
    public String editOrg(Model model, @PathVariable String name){
        OrgFormDTO orgFormDTO = OrganisationMapper.organisationToDTO(organisationService.getOne(name).orElseThrow(RuntimeException::new));
        model.addAttribute("org",orgFormDTO);
        return "edit";
    }


}
