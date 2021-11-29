package reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.function.DoubleBinaryOperator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.apache.poi.ss.usermodel.CellType.*;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;

public class Main {

    //private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {

        //System.setProperty("log4j.configurationFile","./log4j2.xml");
        //Logger log = LogManager.getLogger(Main.class.getName());

        /*Workbook wb = new HSSFWorkbook(); // содание экз. класса HSSFWorkbook, ссылка на него это wb
        Sheet sheet0 = wb.createSheet("НСТ"); // создание листа
        Row row = sheet0.createRow(3); // "создание/объявление" строки 3
        Cell cell = row.createCell(3); // "создание/объявление" ячейки 3 в строке 3
        cell.setCellValue("НСТ");

        Sheet sheet1 = wb.createSheet("АДМ");
        Sheet sheet2 = wb.createSheet("ПГС");
        Sheet sheet3 = wb.createSheet("ИСУ");


        FileOutputStream fos = new FileOutputStream("MyBook.xls"); //создаем поток для работы с файлом...

        wb.write(fos);
        fos.close(); */ // поработали с потоком, закрыли поток

        //********************пробуем читать из файла********************//

        FileInputStream streamA = new FileInputStream("test.xls");
        Workbook workA = new HSSFWorkbook(streamA);

        FileInputStream streamB = new FileInputStream("test_1.xls");
        Workbook workB = new HSSFWorkbook(streamB);

        CellStyle newStyle = workB.createCellStyle();
        //style.setFillBackgroundColor(IndexedColors.RED.getIndex());
        newStyle.setFillPattern(FillPatternType.LESS_DOTS);


        for (int rowCount = 2; rowCount < 5; rowCount++)
        {
            for (int cellCount = 2; cellCount < 5; cellCount++)
            {
                System.out.println("_" + cellCount + "_" + rowCount);

                //String result0 = workA.getSheetAt(0).getRow(row).getCell(cell).getStringCellValue(); // получаем данные 1 добавить метод getCellText(Cell cell)
                String result0 = "";
                Sheet sheet0 = workA.getSheetAt(0);
                Row row0 = sheet0.getRow(rowCount);
                Cell cell0 = row0.getCell(cellCount);

                switch (cell0.getCellType()) {
                    case STRING:
                        System.out.println(cell0.getRichStringCellValue().getString());
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell0)) {
                            result0 = cell0.getDateCellValue().toString();
                        } else {
                            result0 = Double.toString(cell0.getNumericCellValue());
                        }
                        break;
                    case BOOLEAN:
                        result0 = Boolean.toString(cell0.getBooleanCellValue());
                        break;
                    case FORMULA:
                        result0 = cell0.getCellFormula().toString();
                        break;
                    default:
                        break;
                }

                System.out.println(result0);

                //String result1 = workB.getSheetAt(0).getRow(rowCount).getCell(cellCount).getStringCellValue(); // получаем данные 2
                String result1 = "";
                Sheet sheet1 = workB.getSheetAt(0);
                Row row1 = sheet1.getRow(rowCount);
                Cell cell1 = row1.getCell(cellCount);

                switch (cell1.getCellType()) {
                    case STRING:
                        System.out.println(cell1.getRichStringCellValue().getString());
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell1)) {
                            result1 = cell1.getDateCellValue().toString();
                        } else {
                            result1 = Double.toString(cell1.getNumericCellValue());
                        }
                        break;
                    case BOOLEAN:
                        result1 = Boolean.toString(cell1.getBooleanCellValue());
                        break;
                    case FORMULA:
                        result1 = cell1.getCellFormula().toString();
                        break;
                    default:
                        break;
                }
                System.out.println(result1);

                if (result0 != null && result1 != null)
                {
                    if (!result0.equals(result1))
                    {
                        // придаем текущей ячейке новый стиль
//                        Sheet sheet1 = workB.getSheetAt(0);
//                        Row row1 = sheet1.getRow(rowCount);
//                        Cell cell1 = row1.getCell(cellCount);
                        cell1.setCellStyle(newStyle);
                    }
                }
            }
        }

        streamA.close();
        streamB.close();


        FileOutputStream writeStream = new FileOutputStream("test_1.xls");
        workB.write(writeStream);
        writeStream.close();

    }
}
