package com.ltimindtree.reports.controller;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.io.File;

@Controller
public class ReportController {

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String reportExcel() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        System.out.println("I'm here //////");
        XSSFSheet spreadsheet = workbook.createSheet(" Apple Transit Excel File Report ");
        System.out.println("I'm here ++++++");

        XSSFRow row;

        Map<String, Object[]> appleData = new TreeMap<String, Object[]>();
        System.out.println("I'm here _____======> " + appleData);
        //for(int i=1; i<obj.length;i++) {
        //appleData.put("i", new Object[] {obj.get(i).getcount(), obj.get(i).gethighestDateProcessed(), obj.get(i).gettransactionType(), obj.get(i).getcountryCode(), obj.get(i).getprocessorType()});
        appleData.put("1", new Object[] {"count", "highestDateProcessed",
                "transactionType", "countryCode", "processorType"});
        appleData.put("2", new Object[] {"10", "4/27/23 7:02 AM", "856", "CA", "Canada 856"});
        appleData.put("3", new Object[] {"239", "4/27/23 7:16 AM", "870", "CA", "Canada 870"});
        appleData.put("4", new Object[] {"241", "4/27/23 7:17 AM", "856", "US", "US 856"});
        appleData.put("5", new Object[] {"932", "4/27/23 7:21 AM", "870", "US", "US 870"});
        appleData.put("6", new Object[] {"127522", "4/27/23 1:40 AM", "AppleIMEIFileData", "", "AppleIMEIFileData"});
        appleData.put("7", new Object[] {"60303", "4/27/23 12:14 AM", "AppleInTransitShipment", "", "AppleInTransitShipment"});
        appleData.put("8", new Object[] {"4141", "4/27/23 3:25 AM", "AppleOpenOrderFileData", "", "AppleOpenOrderFileData"});
        appleData.put("9", new Object[] {"1764", "4/12/23 6:40 AM", "MicrosoftOpenOrderFileData", "", "MicrosoftOpenOrderFileData"});
        appleData.put("10", new Object[] {"OLR", "", "", "", ""});
        appleData.put("11", new Object[] {"1", "4/27/23 1:59 AM", "VendorSftp", "", "AppleIMEIFileProcessor"});
        appleData.put("12", new Object[] {"10", "4/27/23 5:25 AM", "VendorSftp", "", "AppleInTransitFileProcessor"});
        appleData.put("13", new Object[] {"1", "4/27/23 3:29 AM", "VendorSftp", "", "AppleOpenOrderFileProcessor"});
        appleData.put("14", new Object[] {"461", "4/27/23 7:24 AM", "", "US", "OrderStatusHeader"});
        appleData.put("15", new Object[] {"20", "4/27/23 7:09 AM", "", "CA", "OrderStatusHeader"});
        //}
        Set<String> keyid = appleData.keySet();
        int rowid = 0;

        System.out.println("I'm here ======> " + appleData);
        for(String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = appleData.get(key);
            int cellid = 0;

            for(Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

        FileOutputStream out = new FileOutputStream(new File("C:/Chaitanya/AppleExcelReport.xlsx"));
        workbook.write(out);
        out.close();
        return "Success";
    }
}
