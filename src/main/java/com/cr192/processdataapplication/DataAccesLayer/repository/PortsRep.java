package com.cr192.processdataapplication.DataAccesLayer.repository;

import com.cr192.processdataapplication.CommonLayer.Entity.Ports;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortsRep extends CrudRepository<Ports, Integer> {

    @Query("select p.idPort from Ports p where p.locationPort = ?1")
    Optional<Integer> getIdPortByNamePort(String namePort);
}

