package reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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

        FileInputStream fis = new FileInputStream("C:/git/tutorial/Java/IntelliJ IDEA/ExcelReader/test.xls");
        Workbook workB = new HSSFWorkbook(fis);
        //________________________лист_0_______строка_2_____ячейка(столбец)_3____забрать_данные_типа_String
        //String result0 = workB.getSheetAt(0).getRow(2).getCell(3).getStringCellValue();
        //System.out.println(result0);

        fis.close(); // поработали с потоком, закрыли поток
        int count = 0;  // счетчик итераций для for(Row row : workB.getSheetAt(0))
        String[] box = new String[100];

        //перебор всех строк, ячеек(столбцов) с последующим выводом награбленного
        for(Row row : workB.getSheetAt(0)){ // перебираем 0 лист файла test.xls по строкам
            for(Cell cell : row){             // для строки файла test.xls перебираем ячейки
                System.out.println(getCellText(cell)); // выводим то что нашли в ячейке
                box [count] = getCellText(cell); // загружаем в массив box, то что получили из test.xls
                count++;

            }
        }

        for (int j=0; j< count; j++) {
            System.out.println(box [j]);
        }


    }
    //метод для вывода из ячейки различных типов данных
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
    }
}
