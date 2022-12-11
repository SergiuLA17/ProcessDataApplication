package com.cr192.processdataapplication.DataAccesLayer.DAO;

import com.cr192.processdataapplication.ComminLayer.Entity.Ship;
import com.cr192.processdataapplication.DataAccesLayer.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DAOship
{
    @Autowired
    ShipRepository shipRepository;

    public Optional<Integer> getShipIdByShipName(String shipName) {

        return shipRepository.getShipIdByShipName(shipName);
    }

    public void saveShip(Ship ship) {
        shipRepository.save(ship);
    }
}
