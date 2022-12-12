package com.cr192.processdataapplication.DataAccesLayer.repository;

import com.cr192.processdataapplication.CommonLayer.Entity.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRep  extends JpaRepository<Documents, Long> {

}

