package com.cr192.processdataapplication.BussinesLayer.service.processService;

import com.cr192.processdataapplication.CommonLayer.Entity.Containers;
import com.cr192.processdataapplication.DataAccesLayer.repository.ContainerRep;
import com.cr192.processdataapplication.controller.DeliveryController;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

@Component
public class ProcessContainerListFile {
    @Autowired
    private ContainerRep daoContainer;

    private void readFile(InputStream reapExcelDataFile) throws IOException, ParseException {
        XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile);
        XSSFSheet worksheet = workbook.getSheetAt(0);

        int numberOfColumns = worksheet.getRow(0).getPhysicalNumberOfCells();

        int numberOfRows = worksheet.getPhysicalNumberOfRows();

        for (int i = 1; i < numberOfRows; i++) {
            XSSFRow row = worksheet.getRow(i);
            for (int j = 1; j < numberOfColumns; j++) {
                String data = row.getCell(j).toString();
                    Containers sqlContainer = new Containers();
                    sqlContainer.setSerialCont(Integer.parseInt(data.substring(0, data.length() - 2)));
                    sqlContainer.setIdDoc(DeliveryController.deliveryData.getIdMainDocument());
                    daoContainer.save(sqlContainer);
                    DeliveryController.deliveryData.setIdContainers(sqlContainer.getIdCont());
                    System.out.println("Container: " + sqlContainer + " added to DB");
                }

            }
    }

    public void process(InputStream reapExcelDataFile) throws IOException, ParseException {
        readFile(reapExcelDataFile);
    }
}
