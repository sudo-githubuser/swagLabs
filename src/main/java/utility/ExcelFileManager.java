package utility;

import dataProvider.ConfigFileReader;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileManager {
    private static String excelFilePath ;

    static {
        ConfigFileReader configReader = new ConfigFileReader();
        excelFilePath = configReader.getExcelFilePath();
    }

    public static Map<String, String> readExcelData(){
        Map<String, String> dataMap = new HashMap<>();

        try (FileInputStream file = new FileInputStream(new File(excelFilePath));
             Workbook workbook = new XSSFWorkbook(file)){

            Sheet sheet = workbook.getSheetAt(0); // Reads First Sheet

            for (Row row : sheet) {
                Cell keyCell = row.getCell(0); // First column (key)
                Cell valueCell = row.getCell(1); // Second column (value)

                if(keyCell != null && valueCell != null) {
                    dataMap.put(keyCell.getStringCellValue(), valueCell.getStringCellValue());
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading excel file: " + e.getMessage());
        }
        return dataMap;
    }
}
