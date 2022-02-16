package com.joaoval.WStest.services.implementation;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

@Service
public class FileUploaderService {

    public String uploadDir;

    @Autowired
    ExcelDataService excelService;

    public String uploadFile(MultipartFile file) {

        File arquivoLocal = new File("C:\\Users\\João\\Downloads\\WSwork\\WS\\WS-work.xlsx");
        try {
            
            file.transferTo(arquivoLocal);
            FileInputStream stream = new FileInputStream(arquivoLocal);

            Workbook workbook = new XSSFWorkbook(stream);

            /**
             * Logica do bagulho
             */

            excelService.getExcelDataAsList(workbook);


            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            arquivoLocal.delete();
        }
        return "Ok";
    }
}
