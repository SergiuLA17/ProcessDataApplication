package com.cr192.processdataapplication.BussinesLayer.Util.addDataToDB;

import com.cr192.processdataapplication.CommonLayer.Models.UploadModels.UploadDocumentModel;
import com.cr192.processdataapplication.BussinesLayer.Util.addDataToDB.tables.AddDocuments;
import com.cr192.processdataapplication.BussinesLayer.Util.addDataToDB.tables.AddProduct;
import com.cr192.processdataapplication.CommonLayer.Models.UploadModels.UploadProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddingService{
    @Autowired
    private AddDocuments addDocuments;
    @Autowired
    private AddProduct addProduct;

    public void addDocument(UploadDocumentModel documents) {
        addDocuments.add(documents);
    }

    public void addProduct(UploadProductModel product) {
        addProduct.add(product);
    }



}
