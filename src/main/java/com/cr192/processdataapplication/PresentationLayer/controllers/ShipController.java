package com.cr192.processdataapplication.PresentationLayer.controllers;

import com.cr192.processdataapplication.DataAccesLayer.ProdRep;
import com.cr192.processdataapplication.DataAccesLayer.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import  com.cr192.processdataapplication.DataAccesLayer.ShipRepository;

@RestController
public class ShipController {
    @Autowired
    private ShipRepository eRepo;

    @GetMapping({"/list" , "/"})
    public ModelAndView getAllEmployees() {
        ModelAndView mav = new ModelAndView("list-ship");
        mav.addObject("ship", eRepo.findAll());
        return mav;
    }
}

