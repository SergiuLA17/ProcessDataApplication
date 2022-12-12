package com.cr192.processdataapplication.BussinesLayer.Util.addDataToDB.tables;

import com.cr192.processdataapplication.CommonLayer.Entity.Documents;
import com.cr192.processdataapplication.CommonLayer.Entity.Ship;
import com.cr192.processdataapplication.CommonLayer.Models.UploadModels.UploadDocumentModel;
import com.cr192.processdataapplication.DataAccesLayer.repository.DocumentRep;
import com.cr192.processdataapplication.DataAccesLayer.repository.PortsRep;
import com.cr192.processdataapplication.DataAccesLayer.repository.ShipRepository;
import com.cr192.processdataapplication.controller.DeliveryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddDocuments implements iAdd {
    @Autowired
    private ShipRepository daoShip;
    @Autowired
    private PortsRep daoPorts;
    @Autowired
    private DocumentRep daoDocument;

    public void add(UploadDocumentModel document) {
        Documents sqlDoc = new Documents();
        sqlDoc.setDateStarDelivery(document.getDateStarDelivery());
        sqlDoc.setIdPortNameStart(daoPorts.getIdPortByNamePort(document.getPortNameStart()).get());
        sqlDoc.setIdPortNameFinish(daoPorts.getIdPortByNamePort(document.getPortNameStart()).get());
        sqlDoc.setDateFinishDelivery(document.getDateFinishDelivery());
        if(checkIfShipExist(document.getShipName())){
            System.out.println("Ship exist in database");
            sqlDoc.setShipId(daoShip.getShipIdByShipName(document.getShipName()).get());
        }else {
            Ship ship = new Ship(document.getShipName(), document.getShipCapName());
            daoShip.save(ship);
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
