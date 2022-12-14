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
public class Ports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idPort;
    String namePort;
    String locationPort;
    String phonePort;
}
