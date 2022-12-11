package com.cr192.processdataapplication.DataAccesLayer.repository;

import com.cr192.processdataapplication.ComminLayer.Entity.depotype;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TypeDepRep extends CrudRepository<depotype, Integer> {


    @Query("select t.idDep from depotype t where t.typeDep = ?1")
    Optional<Integer> getTypeDepositsByNameDeposit(String nameDeposit);
}
