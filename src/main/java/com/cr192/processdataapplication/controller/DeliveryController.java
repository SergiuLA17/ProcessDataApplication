package com.cr192.processdataapplication.controller;

import com.cr192.processdataapplication.BussinesLayer.service.ProcessContainerListFile;
import com.cr192.processdataapplication.BussinesLayer.service.ProcessDocumentFIle;
import com.cr192.processdataapplication.BussinesLayer.service.ProcessProductList;
import com.cr192.processdataapplication.ComminLayer.Entity.Stock;
import com.cr192.processdataapplication.ComminLayer.Models.CommonModels.Delivery;
import com.cr192.processdataapplication.DataAccesLayer.DAO.DAOstock;
import com.cr192.processdataapplication.DataAccesLayer.repository.ProductRep;
import com.cr192.processdataapplication.DataAccesLayer.repository.ShipRepository;
import com.cr192.processdataapplication.DataAccesLayer.repository.TypeDepRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDateTime;
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
    private TypeDepRep typeDepRep;
    @Autowired
    private ProductRep productRep;
    @Autowired
    private DAOstock daoStock;

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

        for (int i = 0; i < deliveryData.getIdProducts().size(); i++) {
            Stock stock = new Stock();
            stock.setDate(LocalDateTime.now());
            stock.setIdDoc(deliveryData.getIdMainDocument());
            stock.setIdProd(deliveryData.getIdProducts().get(i));
            int idProduct = deliveryData.getIdProducts().get(i);
            String categProd = productRep.getIdProdByCategProd(idProduct).get();
            int idDep = typeDepRep.getTypeDepositsByNameDeposit(categProd).get();
            stock.setIdDep(idDep);
            daoStock.save(stock);
            System.out.println("Prdoduct was added to stock:" + stock);
        }



    }
}