package com.cr192.processdataapplication.DataAccesLayer.repository;

import com.cr192.processdataapplication.ComminLayer.Entity.Containers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContainerRep extends CrudRepository<Containers, Integer> {

    @Query("select c.idCont from Containers c where c.serialCont = ?1 and c.idDoc = ?2")
    Optional<Integer> getContainersBySerialContAndAndIdDoc(int serialCont, int idDoc);
}
