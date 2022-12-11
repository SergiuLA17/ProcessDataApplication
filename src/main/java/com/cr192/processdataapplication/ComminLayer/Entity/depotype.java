package com.cr192.processdataapplication.ComminLayer.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class depotype {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idDep;
    String typeDep;
}
