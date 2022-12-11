package com.cr192.processdataapplication.BussinesLayer.Util.addDataToDB.tables;

import com.cr192.processdataapplication.ComminLayer.Entity.Product;
import com.cr192.processdataapplication.ComminLayer.Models.UploadModels.UploadProductModel;
import com.cr192.processdataapplication.DataAccesLayer.DAO.DAOcontainer;
import com.cr192.processdataapplication.DataAccesLayer.DAO.DAOproduct;
import com.cr192.processdataapplication.controller.DeliveryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddProduct {
    @Autowired
    DAOproduct daoProduct;
    @Autowired
    DAOcontainer daoContainer;

    public void add(UploadProductModel documents) {
        Product product = new Product();
        product.setNameProd(documents.getNameProd());
        product.setIdCont(daoContainer.getContIdBySerialContAndIdDoc(documents.getContainer()).get());
        product.setQuantity(documents.getQuantity());
        product.setDateOfManufacture(documents.getDateOfManufacture());
        product.setDayToExpire(documents.getDayToExpire());
        product.setCategProd(documents.getTypeProd());
        product.setCompName(documents.getCompName());
        daoProduct.saveProduct(product);
        System.out.println("Product: " + product + " added to DB");
        DeliveryController.deliveryData.setIdProducts(product.getIdProd());
    }
}
