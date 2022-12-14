package com.cr192.processdataapplication.BussinesLayer.Util.addDataToDB.tables;

import com.cr192.processdataapplication.CommonLayer.Entity.Product;
import com.cr192.processdataapplication.CommonLayer.Models.UploadModels.UploadProductModel;
import com.cr192.processdataapplication.DataAccesLayer.repository.ContainerRep;
import com.cr192.processdataapplication.DataAccesLayer.repository.ProductRep;
import com.cr192.processdataapplication.controller.DeliveryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddProduct {
    @Autowired
    ProductRep daoProduct;
    @Autowired
    ContainerRep daoContainer;

    public void add(UploadProductModel documents) {
        Product product = new Product();
        product.setNameProd(documents.getNameProd());
        product.setIdCont(getIdContainer(documents.getContainer()));
        product.setQuantity(documents.getQuantity());
        product.setDateOfManufacture(documents.getDateOfManufacture());
        product.setDayToExpire(documents.getDayToExpire());
        product.setCategProd(documents.getTypeProd());
        product.setCompName(documents.getCompName());
        product.setRecipentEmail(documents.getRecipentEmail());
        product.setRecipentPhone(documents.getRecipentPhone());

        daoProduct.save(product);
        System.out.println("Product: " + product + " added to DB");
        DeliveryController.deliveryData.setIdProducts(product.getIdProd());
        System.out.println(DeliveryController.deliveryData);
        //send email to recipent
    }

    public int getIdContainer(int idContainer){
        return daoContainer.getContainersBySerialContAndAndIdDoc(idContainer, DeliveryController.deliveryData.getIdMainDocument()).get();
    }
}
