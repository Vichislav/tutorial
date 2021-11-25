package reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    //private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {

        //System.setProperty("log4j.configurationFile","./log4j2.xml");
        //Logger log = LogManager.getLogger(Main.class.getName());

        Workbook wb = new HSSFWorkbook(); // содание экз. класса HSSFWorkbook, ссылка на него это wb
        Sheet sheet0 = wb.createSheet("НСТ"); // создание листа
        Row row = sheet0.createRow(3); // "создание/объявление" строки 3
        Cell cell = row.createCell(3); // "создание/объявление" ячейки 3 в строке 3
        cell.setCellValue("НСТ");

        Sheet sheet1 = wb.createSheet("АДМ");
        Sheet sheet2 = wb.createSheet("ПГС");
        Sheet sheet3 = wb.createSheet("ИСУ");


        FileOutputStream fos = new FileOutputStream("MyBook.xls");

        wb.write(fos);
        fos.close();

    }
}
