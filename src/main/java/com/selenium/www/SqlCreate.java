package com.selenium.www;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

public class SqlCreate {
    public static void main(String[] args) throws IOException {
        File fileXLSX = new File("D:\\到货单.xlsx");
        InputStream inputStream = new FileInputStream(fileXLSX);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        try {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for(int i=0;i<row.getLastCellNum();i++){
                    if(row.getCell(i)!=null){
                        row.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
                    }
                    String danci = row.getCell(i).getStringCellValue();
                    System.out.print(danci+" ");
                }
                System.out.println();
            }
        } catch (EncryptedDocumentException e) {
            e.printStackTrace();
        } finally {

        }
    }

}
