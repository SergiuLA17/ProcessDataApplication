package com.cr192.processdataapplication.ComminLayer.Models.CommonModels;


import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Delivery {
    private int idMainDocument;
    private List<Integer> idContainers = new ArrayList<>();
    private List<Integer> idProducts = new ArrayList<>();

    public Delivery() {
    }

    public int getIdMainDocument() {
        return idMainDocument;
    }

    public void setIdMainDocument(int idMainDocument) {
        this.idMainDocument = idMainDocument;
    }

    public void setIdContainers(int id) {
        idContainers.add(id);
    }
    public void setIdProducts(int id) {
        idProducts.add(id);
    }

    public List<Integer> getIdProducts() {
        return idProducts;
    }
}
