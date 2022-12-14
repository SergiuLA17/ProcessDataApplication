package com.cr192.processdataapplication.CommonLayer.Models.UploadModels;

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
    private String shipName;
    private String shipCapName;
    private String PortNameStart;
    private String PortNameFinish;

    public UploadDocumentModel() {
    }
}
