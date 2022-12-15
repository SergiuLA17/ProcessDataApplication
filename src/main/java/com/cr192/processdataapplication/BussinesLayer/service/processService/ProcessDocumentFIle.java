package com.cr192.processdataapplication.BussinesLayer.service.processService;

import com.cr192.processdataapplication.BussinesLayer.Util.addDataToDB.AddingService;
import com.cr192.processdataapplication.CommonLayer.Models.UploadModels.UploadDocumentModel;
import org.apache.poi.EmptyFileException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class ProcessDocumentFIle {
    @Autowired
    private AddingService addingService;
    private UploadDocumentModel uploadDocumentModel;

    private void readFile(InputStream reapExcelDataFile) throws IOException, ParseException {
        try (reapExcelDataFile) {
            System.out.println(reapExcelDataFile);
            XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile);
            XSSFSheet worksheet = workbook.getSheetAt(0);

            int numberOfColumns = worksheet.getRow(0).getPhysicalNumberOfCells();

            int numberOfRows = worksheet.getPhysicalNumberOfRows();

            for (int i = 1; i < numberOfRows; i++) {
                XSSFRow row = worksheet.getRow(i);
                for (int j = 1; j < numberOfColumns; j++) {
                    processDocument(row.getCell(j).toString(), i - 1);
                }
            }
            addingService.addDocument(uploadDocumentModel);
        } catch (EmptyFileException e) {
            System.out.println("No file found");
        }
    }


    private void processDocument(String data, int j) throws ParseException {
        switch (j) {
            case 0 -> {
                uploadDocumentModel= new UploadDocumentModel();
                uploadDocumentModel.setDateStarDelivery(new SimpleDateFormat("dd/MM/yyyy").parse(data));
            }
            case 1 -> uploadDocumentModel.setDateFinishDelivery(new SimpleDateFormat("dd/MM/yyyy").parse(data));
            case 2 -> uploadDocumentModel.setPortNameStart(data);
            case 3 -> uploadDocumentModel.setPortNameFinish(data);
            case 4 -> uploadDocumentModel.setShipName(data);
            case 5 -> uploadDocumentModel.setShipCapName(data);

            default -> throw new IllegalStateException("Unexpected value: " + j);
        }
    }


    public void process(InputStream reapExcelDataFile) throws IOException, ParseException {
        readFile(reapExcelDataFile);
    }
}
