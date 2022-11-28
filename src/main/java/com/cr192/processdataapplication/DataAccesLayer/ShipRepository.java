package com.cr192.processdataapplication.DataAccesLayer;

import com.cr192.processdataapplication.ComminLayer.Entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cr192.processdataapplication.ComminLayer.Entity.Ship;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

}
