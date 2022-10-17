package com.cr192.processdataapplication.DataAccesLayer;

import com.cr192.processdataapplication.ComminLayer.Entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface interfase extends CrudRepository<Product, Integer> {
    //@Query("select p.name_product, c.name_company from Product p left join Company c on c.id_company = p.company_id")
    @Query("select p.name_product, c.name_company from Product p  left join Company c on c.id_company = p.company_id")
    Iterable<Product> findAlll();

    @Override
    Iterable<Product> findAll();
}