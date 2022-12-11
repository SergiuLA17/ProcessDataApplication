package com.cr192.processdataapplication.ComminLayer.Models.UploadModels;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Data
@Getter
@Setter
@ToString
public class UploadDocumentModel {
    private Date dateStarDelivery;
    private Date dateFinishDelivery;
    private String starLocation;
    private String finishLocation;
    private String shipName;
    private String shipCapName;

    public UploadDocumentModel() {
    }
}
