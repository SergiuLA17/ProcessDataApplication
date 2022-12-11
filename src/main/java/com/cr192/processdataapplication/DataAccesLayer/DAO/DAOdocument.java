package com.cr192.processdataapplication.DataAccesLayer.DAO;

import com.cr192.processdataapplication.ComminLayer.Entity.Documents;
import com.cr192.processdataapplication.DataAccesLayer.repository.DocumentRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DAOdocument {
    @Autowired
    DocumentRep documentRep;

    public void save(Documents document) {
        documentRep.save(document);
    }
}
