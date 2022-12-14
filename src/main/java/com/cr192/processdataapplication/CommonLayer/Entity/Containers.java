package com.cr192.processdataapplication.CommonLayer.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Containers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCont;
    int serialCont;
    int idDoc;

    public Containers() {
    }
}
