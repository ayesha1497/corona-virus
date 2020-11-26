package com.corona.virus.coronavirus.controller;

import com.corona.virus.coronavirus.service.CoronaVirusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.inject.Inject;

@Controller
public class CoronaVirusController {

    @Inject
    private CoronaVirusService coronaVirusService;

    @GetMapping("/corona-virus/information")
    public String retrieveCoronaVirusInformation(final Model model) {
        model.addAttribute("coronaVirusLocations", coronaVirusService.getAllCoronaVirusInformation());
        return "corona-virus-information";
    }
}
