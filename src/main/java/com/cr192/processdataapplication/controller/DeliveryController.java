package com.cr192.processdataapplication.controller;

import com.cr192.processdataapplication.BussinesLayer.service.emailService.Email;
import com.cr192.processdataapplication.BussinesLayer.service.processService.ProcessContainerListFile;
import com.cr192.processdataapplication.BussinesLayer.service.processService.ProcessDocumentFIle;
import com.cr192.processdataapplication.BussinesLayer.service.processService.ProcessProductList;
import com.cr192.processdataapplication.BussinesLayer.service.stockService.StockService;
import com.cr192.processdataapplication.CommonLayer.Models.CommonModels.Delivery;
import com.cr192.processdataapplication.DataAccesLayer.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;


@RestController
public class DeliveryController {
    static public Delivery deliveryData;
    @Autowired
    private ProcessDocumentFIle processDocument;
    @Autowired
    private ProcessContainerListFile processContainerListFile;
    @Autowired
    private ProcessProductList processProductList;
    @Autowired
    private ShipRepository shipRepository;
    @Autowired
    private StockService stock;
    @Autowired
    private Email email;

    @GetMapping({"/list", "/"})
    public ModelAndView getAllEmployees() {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("ship", shipRepository.findAll());
        return mav;
    }

    @PostMapping("/importDocuments")
    public void importDocument(@RequestParam("file") ArrayList<MultipartFile> reapExcelDataFile) throws IOException, ParseException {
        deliveryData = new Delivery();
        for (int i = 0; i < reapExcelDataFile.size(); i++) {
            if (i == 0) {
                processDocument.process(reapExcelDataFile.get(i));
            } else if (i == 1) {
                processContainerListFile.process(reapExcelDataFile.get(i));
            } else if (i==2) {
                processProductList.process(reapExcelDataFile.get(i));
            }

        }
        stock.add(deliveryData);
        email.send();
    }
}