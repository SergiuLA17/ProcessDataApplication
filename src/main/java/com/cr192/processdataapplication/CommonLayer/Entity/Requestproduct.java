package com.cr192.processdataapplication.CommonLayer.Entity;

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
public class Requestproduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idReq;
    Date dateReq;
    int idDoc;
    int idProd;


    public Requestproduct() {

    }
}
