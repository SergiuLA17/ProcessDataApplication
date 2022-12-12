package com.cr192.processdataapplication.DataAccesLayer.repository;

import com.cr192.processdataapplication.CommonLayer.Entity.Ship;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShipRepository extends CrudRepository<Ship, Integer> {


  @Query("select s.idShip from Ship as s where s.shipName = ?1")
  Optional<Integer> getShipIdByShipName(String shipName);


}
