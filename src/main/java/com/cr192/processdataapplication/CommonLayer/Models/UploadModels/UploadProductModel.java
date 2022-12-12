package com.cr192.processdataapplication.CommonLayer.Models.UploadModels;


import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class UploadProductModel {
    int idProduct;
    String NameProd;
    int Quantity;
    Date DateOfManufacture;
    int DayToExpire;
    int container;
    String TypeProd;
    String CompName;
    String CompPhone;
    String CountryCompany;
    String RecipentEmail;
    String RecipentPhone;
}
