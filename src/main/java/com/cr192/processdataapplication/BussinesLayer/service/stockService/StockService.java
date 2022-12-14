package com.cr192.processdataapplication.BussinesLayer.service.stockService;

import com.cr192.processdataapplication.CommonLayer.Entity.Stock;
import com.cr192.processdataapplication.CommonLayer.Models.CommonModels.Delivery;
import com.cr192.processdataapplication.DataAccesLayer.repository.ProductRep;
import com.cr192.processdataapplication.DataAccesLayer.repository.StockRep;
import com.cr192.processdataapplication.DataAccesLayer.repository.TypeDepRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StockService {
    @Autowired
    private ProductRep productRep;
    @Autowired
    private TypeDepRep typeDepRep;
    @Autowired
    private StockRep stockRep;

    public void add(Delivery deliveryData) {
        for (int i = 0; i < deliveryData.getIdProducts().size(); i++) {
            Stock stock = new Stock();
            stock.setDate(LocalDateTime.now());
            stock.setIdDoc(deliveryData.getIdMainDocument());
            stock.setIdProd(deliveryData.getIdProducts().get(i));
            stock.setIdDep(getIdDeposit(deliveryData.getIdProducts().get(i)));
            stockRep.save(stock);
            System.out.println("Prdoduct was added to stock:" + stock);
        }
    }

    private int getIdDeposit(int i){
        String categProd = productRep.getCategoryProduct(i).get();
        return typeDepRep.getTypeDepositsByNameDeposit(categProd).get();
    }
}
