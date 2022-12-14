package com.cr192.processdataapplication.DataAccesLayer.repository;

import com.cr192.processdataapplication.CommonLayer.Entity.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.Optional;

@Repository
public interface DocumentRep  extends CrudRepository<Documents, Integer> {

    @Query("select d.dateFinishDelivery from Documents d where d.idDoc = ?1")
    Optional<Date> getDataDocByIdDoc(int idDoc);
}

