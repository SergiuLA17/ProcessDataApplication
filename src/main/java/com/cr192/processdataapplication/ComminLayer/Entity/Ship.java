package com.cr192.processdataapplication.ComminLayer.Entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="ship")
@AllArgsConstructor
@NoArgsConstructor
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idShip;
    private String shipName;
    private String shipCapName;

}
