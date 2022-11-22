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
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idDoc;
    Date dateStarDelivery;
    Date dateFinishDelivery;
    int idShip;
    String starLocation;
    String finishLocation;

    public Document() {

    }
}
