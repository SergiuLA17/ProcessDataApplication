package com.cr192.processdataapplication.CommonLayer.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idProd;
    String nameProd;
    int idCont;
    int quantity;
    Date dateOfManufacture;
    int dayToExpire;
    String categProd;
    String compName;
    String recipentEmail;
    String recipentPhone;

    public Product() {

    }
}
