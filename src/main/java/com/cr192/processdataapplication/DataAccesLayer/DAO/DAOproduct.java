package com.cr192.processdataapplication.DataAccesLayer.DAO;

import com.cr192.processdataapplication.ComminLayer.Entity.Product;
import com.cr192.processdataapplication.DataAccesLayer.repository.ProductRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DAOproduct {
    @Autowired
    ProductRep productRep;

    public void saveProduct(Product product) {
        productRep.save(product);
    }
}
