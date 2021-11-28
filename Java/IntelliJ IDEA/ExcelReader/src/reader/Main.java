package reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.*;

import java.io.*;

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

        int rowCount = 2;
        int cellCount = 4; //счетчик не перешагивает, выяснить почему

        while (cellCount < 6) {
            while (rowCount < 5) {

                String result0 = workA.getSheetAt(0).getRow(rowCount).getCell(cellCount).getStringCellValue(); // получаем данные 1
                System.out.println(result0);

                String result1 = workB.getSheetAt(0).getRow(rowCount).getCell(cellCount).getStringCellValue(); // получаем данные 2
                System.out.println(result1);

                if (result0 != null && result1 != null){
                    if (!result0.equals(result1)) {
                        // придаем текущей ячейке новый стиль
                        Sheet sheet0 = workB.getSheetAt(0);
                        Row row0 = sheet0.getRow(rowCount);
                        Cell cell0 = row0.getCell(cellCount);
                        cell0.setCellStyle(newStyle);
                    }

                }
                rowCount++;
        }
            cellCount++;
        }

        streamA.close();
        streamB.close();


        FileOutputStream writeStream = new FileOutputStream("test_1.xls");
        workB.write(writeStream);
        writeStream.close();







    /*//метод для вывода из ячейки различных типов данных
    public static String getCellText(Cell cell) {

        String result = "";

        switch (cell.getCellType()) {
            case STRING:
                System.out.println(cell.getRichStringCellValue().getString());
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    result = cell.getDateCellValue().toString();
                } else {
                    result = Double.toString(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                result = Boolean.toString(cell.getBooleanCellValue());
                break;
            case FORMULA:
                result = cell.getCellFormula().toString();
                break;
            default:
                break;
        }
        return result;
    }*/

    }
}
