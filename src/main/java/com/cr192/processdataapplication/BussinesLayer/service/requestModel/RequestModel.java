package com.cr192.processdataapplication.BussinesLayer.service.requestModel;

import com.cr192.processdataapplication.CommonLayer.Entity.Containers;
import com.cr192.processdataapplication.CommonLayer.Entity.Documents;
import com.cr192.processdataapplication.CommonLayer.Entity.Ports;
import com.cr192.processdataapplication.CommonLayer.Entity.Product;
import com.cr192.processdataapplication.DataAccesLayer.repository.ContainerRep;
import com.cr192.processdataapplication.DataAccesLayer.repository.DocumentRep;
import com.cr192.processdataapplication.DataAccesLayer.repository.PortsRep;
import com.cr192.processdataapplication.DataAccesLayer.repository.ProductRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


@Service
public class RequestModel {
    @Autowired
    private ProductRep productRep;
    @Autowired
    private ContainerRep containerRep;
    @Autowired
    private DocumentRep documentRep;
    @Autowired
    private PortsRep portsRep;

    public ModelAndView create(Integer id){
        ModelAndView mav = new ModelAndView("request");
        try {
            if (id == null){
                mav.addObject("productID", "");
                mav.addObject("productName", "");
                mav.addObject("quantity", "");
                mav.addObject("storage", "");
                mav.addObject("contact", "");
            }else {

                System.out.println(id);
                Product product = productRep.findById(id).get();
                Containers container = containerRep.findById(product.getIdCont()).get();
                Documents document = documentRep.findById(container.getIdDoc()).get();
                Ports port = portsRep.findById(document.getIdPortNameFinish()).get();

                mav.addObject("productID", id);
                mav.addObject("productName", product.getNameProd());
                mav.addObject("quantity", product.getQuantity());
                mav.addObject("storage", port.getLocationPort());
                mav.addObject("contact", port.getPhonePort());

                System.out.println("New request for product id " + id);
            }
        } catch (Exception e) {

        }
        return mav;
    }

}
