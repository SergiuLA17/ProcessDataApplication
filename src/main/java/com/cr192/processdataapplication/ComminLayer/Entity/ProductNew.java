package com.cr192.processdataapplication.ComminLayer.Entity;

import java.util.ArrayList;
import java.util.List;

public class ProductNew {
    String name;
    String name2;

    public ProductNew(String name, String name2) {
        this.name = name;
        this.name2 = name2;
    }

    @Override
    public String toString() {
        return "ProductNew{" +
                "name='" + name + '\'' +
                ", name2='" + name2 + '\'' +
                '}';
    }
}
