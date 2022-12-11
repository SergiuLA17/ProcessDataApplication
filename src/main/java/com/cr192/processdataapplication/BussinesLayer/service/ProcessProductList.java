package com.cr192.processdataapplication.BussinesLayer.service;

import com.cr192.processdataapplication.BussinesLayer.Util.addDataToDB.AddingService;
import com.cr192.processdataapplication.ComminLayer.Models.UploadModels.UploadProductModel;
import com.cr192.processdataapplication.DataAccesLayer.repository.ShipRepository;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


@Component
public class ProcessProductList {
    @Autowired
    private ShipRepository shipRepository;
    @Autowired
    private AddingService addingService;
    ArrayList<UploadProductModel> products = new ArrayList<>();

    private void readFile(MultipartFile reapExcelDataFile) throws IOException, ParseException {
        products.clear();
        XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);

        int numberOfColumns = worksheet.getRow(0).getPhysicalNumberOfCells();

        int numberOfRows = worksheet.getPhysicalNumberOfRows();

        for (int i = 1; i < numberOfRows; i++) {
            XSSFRow row = worksheet.getRow(i);

            for (int j = 1; j < numberOfColumns; j++) {
                createDocuments(row.getCell(j).toString(), j-1, i-1);
            }
        }
    }

    private void createDocuments(String data, int j, int i) throws ParseException {
        switch (i) {
            case 0 -> {
                UploadProductModel product = new UploadProductModel();
                product.setIdProduct(Integer.parseInt(data));
                products.add(product);
            }
            case 1 -> products.get(j).setNameProd(data);
            case 2 -> products.get(j).setQuantity(Integer.parseInt(data.substring(0, data.length() - 2)));
            case 3 -> products.get(j).setDateOfManufacture(new SimpleDateFormat("dd/MM/yyyy").parse(data));
            case 4 -> products.get(j).setDayToExpire(Integer.parseInt(data.substring(0, data.length() - 2)));
            case 5 -> products.get(j).setTypeProd(data);
            case 6 -> products.get(j).setContainer(Integer.parseInt(data));
            case 7 -> products.get(j).setCompName(data);
            case 8 -> products.get(j).setCompPhone(data);
            case 9 -> products.get(j).setCountryCompany(data);

            default -> throw new IllegalStateException("Unexpected value: " + i);
        }
    }

    private void addDataToDB() {
        for (UploadProductModel product : products) {
            addingService.addProduct(product);
        }
    }

    public void process(MultipartFile reapExcelDataFile) throws IOException, ParseException {
        readFile(reapExcelDataFile);
        addDataToDB();

    }
}
