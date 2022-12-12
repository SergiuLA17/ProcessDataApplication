package com.cr192.processdataapplication.CommonLayer.Entity;


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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idShip;
    private String shipName;
    private String shipCapName;

    public Ship(String shipName, String shipCapName) {
        this.shipName = shipName;
        this.shipCapName = shipCapName;
    }

}
