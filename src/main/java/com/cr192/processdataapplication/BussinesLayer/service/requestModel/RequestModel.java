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

import java.util.Optional;


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
            if (id == null) {
                mav.addObject("message", "Nu ati introdus id!");

            }else {


                Optional<Product> product = productRep.findById(id);
                if (product.isEmpty()) {
                    mav.addObject("message", "Nu exista produs cu id: " + id + ", sau ati introdus date gresite.");
                } else {

                    Containers container = containerRep.findById(product.get().getIdCont()).get();
                    Documents document = documentRep.findById(container.getIdDoc()).get();
                    Ports port = portsRep.findById(document.getIdPortNameFinish()).get();
                    String message = "Product:" + product.get().getNameProd() + ", quantity = " + product.get().getQuantity() + ", storage location: " + port.getLocationPort() + ", contact: " + port.getPhonePort();


                    mav.addObject("message", message);
//                mav.addObject("productName", product.getNameProd());
//                mav.addObject("quantity", product.getQuantity());
//                mav.addObject("storage", port.getLocationPort());
//                mav.addObject("contact", port.getPhonePort());
                }

            }
        return mav;
    }

}
