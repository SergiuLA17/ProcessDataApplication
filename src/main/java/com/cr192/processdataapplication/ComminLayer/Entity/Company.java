package com.cr192.processdataapplication.ComminLayer.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_company;
    private String name_company;

    public Company() {

    }
}
