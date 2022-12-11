package com.cr192.processdataapplication.DataAccesLayer.repository;

import com.cr192.processdataapplication.ComminLayer.Entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRep extends CrudRepository<Product, Integer> {

    @Query("select pr.categProd from Product as pr where  pr.idProd = ?1")
    Optional<String> getIdProdByCategProd(int categProd);
}
