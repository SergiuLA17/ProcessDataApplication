package com.cr192.processdataapplication.ComminLayer.Entity;


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
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idCont;
    int serialCont;
    int idDoc;
    int idComp;

    public Container() {
    }
}
