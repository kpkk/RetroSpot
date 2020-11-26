package Utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ReadFromExcel {

    public static Workbook workbook;


    public static Object[][] readData(String sheetName, String fileLocation) throws Exception {


        workbook = new XSSFWorkbook(fileLocation);
        Sheet sheetAt = workbook.getSheet(sheetName);

        int rowCount = sheetAt.getLastRowNum();
        int colCount = sheetAt.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][colCount];

        for (int i = 1; i <= rowCount; i++) {
            Row row = sheetAt.getRow(i);
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = row.getCell(j).getStringCellValue();


            }
        }


        return data;
    }


}


