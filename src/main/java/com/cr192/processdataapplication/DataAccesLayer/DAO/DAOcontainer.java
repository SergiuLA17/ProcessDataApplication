package com.cr192.processdataapplication.DataAccesLayer.DAO;

import com.cr192.processdataapplication.ComminLayer.Entity.Containers;
import com.cr192.processdataapplication.DataAccesLayer.repository.ContainerRep;
import com.cr192.processdataapplication.controller.DeliveryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DAOcontainer {
    @Autowired
    private ContainerRep containerRep;

    public Optional<Integer> getContIdBySerialContAndIdDoc(int serial) {
        return containerRep.getContainersBySerialContAndAndIdDoc(serial, DeliveryController.deliveryData.getIdMainDocument());
    }

    public void save(Containers container) {
        containerRep.save(container);
    }

}
