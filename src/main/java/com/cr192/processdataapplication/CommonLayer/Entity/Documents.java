package com.cr192.processdataapplication.CommonLayer.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idDoc;
    Date dateStarDelivery;
    Date dateFinishDelivery;
    int idPortNameStart;
    int idPortNameFinish;
    int ShipId;

    public Documents() {

    }
}
