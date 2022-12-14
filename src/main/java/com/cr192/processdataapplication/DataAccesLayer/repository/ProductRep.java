package com.cr192.processdataapplication.DataAccesLayer.repository;

import com.cr192.processdataapplication.CommonLayer.Entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRep extends CrudRepository<Product, Integer> {

    @Query("select pr.categProd from Product as pr where  pr.idProd = ?1")
    Optional<String> getCategoryProduct(int categProd);

    @Query("select pr.recipentEmail from Product as pr where  pr.idProd = ?1")
    Optional<String> getReipentEmail(int id);

    @Query("select pr.recipentPhone from Product as pr where  pr.idProd = ?1")
    Optional<String> getReipentPhone(int id);

}
