package com.cr192.processdataapplication.ComminLayer.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@Entity
public class RequestProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idReq;
    Date dateReq;
    int idDoc;
    int idProd;


    public RequestProduct() {

    }
}
