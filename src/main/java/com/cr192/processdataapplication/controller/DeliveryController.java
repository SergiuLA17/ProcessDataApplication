package com.cr192.processdataapplication.controller;

import com.cr192.processdataapplication.BussinesLayer.service.emailService.Email;
import com.cr192.processdataapplication.BussinesLayer.service.processService.ProcessContainerListFile;
import com.cr192.processdataapplication.BussinesLayer.service.processService.ProcessDocumentFIle;
import com.cr192.processdataapplication.BussinesLayer.service.processService.ProcessProductList;
import com.cr192.processdataapplication.BussinesLayer.service.requestModel.RequestModel;
import com.cr192.processdataapplication.BussinesLayer.service.stockService.StockService;
import com.cr192.processdataapplication.CommonLayer.Models.CommonModels.Delivery;
import com.cr192.processdataapplication.DataAccesLayer.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;


@Controller
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
    @Autowired
    private RequestModel requestModel;

    //de impl dashboard


    @RequestMapping("/request")
    public ModelAndView index(@RequestParam(value = "someName", required = false) Integer id) {

        return requestModel.create(id);
    }


    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/upload")
    public String upload() {
        return "readExcel";
    }


    @PostMapping("/importDocuments")
    public String importDocument(@RequestParam("file") ArrayList<MultipartFile> reapExcelDataFile) throws IOException, ParseException {
        if (reapExcelDataFile.size() < 3) {
            System.out.println();
            return "redirect:/upload";
        }

        if (!reapExcelDataFile.get(0).getOriginalFilename().equals("document.xlsx")) {
            return "redirect:/upload";
        }
        if (!reapExcelDataFile.get(1).getOriginalFilename().equals("containers.xlsx")) {
            return "redirect:/upload";
        }
        if (!reapExcelDataFile.get(2).getOriginalFilename().equals("products.xlsx")) {
            return "redirect:/upload";
        }



        deliveryData = new Delivery();
        for (int i = 0; i < reapExcelDataFile.size(); i++) {
            if (i == 0) {
                processDocument.process(reapExcelDataFile.get(i).getInputStream());
            } else if (i == 1) {
                processContainerListFile.process(reapExcelDataFile.get(i).getInputStream());
            } else if (i == 2) {
                processProductList.process(reapExcelDataFile.get(i).getInputStream());
            }

        }
        stock.add(deliveryData);
        email.send();
        return "importDocuments";

    }
}
