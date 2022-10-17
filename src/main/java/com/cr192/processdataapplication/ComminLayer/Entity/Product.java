package com.cr192.processdataapplication.ComminLayer.Entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_product;
    private String name_product;
    private int quantity;
    private int company_id;

    public Product(int id_product, int company_id) {
        this.id_product = id_product;
        this.company_id = company_id;
    }

    public Product() {
    }
}
