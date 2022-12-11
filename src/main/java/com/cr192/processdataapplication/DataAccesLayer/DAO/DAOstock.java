package com.cr192.processdataapplication.DataAccesLayer.DAO;


import com.cr192.processdataapplication.ComminLayer.Entity.Stock;
import com.cr192.processdataapplication.DataAccesLayer.repository.StockRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DAOstock {
    @Autowired
    private StockRep stockRep;

    public void save(Stock stock) {
        stockRep.save(stock);
    }
}
