package com.cr192.processdataapplication.BussinesLayer.Util.addDataToDB.tables;

import com.cr192.processdataapplication.ComminLayer.Entity.Documents;
import com.cr192.processdataapplication.ComminLayer.Entity.Ship;
import com.cr192.processdataapplication.DataAccesLayer.DAO.DAOdocument;
import com.cr192.processdataapplication.DataAccesLayer.DAO.DAOship;
import com.cr192.processdataapplication.ComminLayer.Models.UploadModels.UploadDocumentModel;
import com.cr192.processdataapplication.controller.DeliveryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddDocuments implements iAdd {
    @Autowired
    private DAOship daoShip;
    @Autowired
    private DAOdocument daoDocument;

    public void add(UploadDocumentModel document) {
        Documents sqlDoc = new Documents();
        sqlDoc.setDateStarDelivery(document.getDateStarDelivery());
        sqlDoc.setDateFinishDelivery(document.getDateFinishDelivery());
        sqlDoc.setStarLocation(document.getStarLocation());
        sqlDoc.setFinishLocation(document.getFinishLocation());
        if(checkIfShipExist(document.getShipName())){
            System.out.println("Ship exist in database");
            sqlDoc.setShipId(daoShip.getShipIdByShipName(document.getShipName()).get());
        }else {
            Ship ship = new Ship(document.getShipName(), document.getShipCapName());
            daoShip.saveShip(ship);
            System.out.println("The ship was added in database: " + ship);
            sqlDoc.setShipId(daoShip.getShipIdByShipName(document.getShipName()).get());
        }

        daoDocument.save(sqlDoc);
        System.out.println("Document added: " + document);
        DeliveryController.deliveryData.setIdMainDocument(sqlDoc.getIdDoc());
    }

    private boolean checkIfShipExist(String shipName) {
       return daoShip.getShipIdByShipName(shipName).isPresent();
    }
}
