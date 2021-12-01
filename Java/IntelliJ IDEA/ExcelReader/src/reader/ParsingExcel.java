package reader;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public final class ParsingExcel {
    public static void EqualExcelFiles(String filePath1, String filePath2, int quantityRow, int quantityCell) throws IOException {

        FileInputStream fileInputStreamA = new FileInputStream(filePath1);
        Workbook workA = new HSSFWorkbook(fileInputStreamA);

        FileInputStream fileInputStreamB = new FileInputStream(filePath2);
        Workbook workB = new HSSFWorkbook(fileInputStreamB);

        FileOutputStream fileOutputStreamB = new FileOutputStream("test_1.xls");

        CellStyle newStyle = workB.createCellStyle();
        newStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
        newStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        for (int rowCount = 0; rowCount < quantityRow; rowCount++) {
            for (int cellCount = 0; cellCount < quantityCell; cellCount++) {
                try {
                    Cell cell0 = workA.getSheetAt(0).getRow(rowCount).getCell(cellCount);
                    String result0 = ParsingExcel.ParsingCell(cell0);

                    Cell cell1 = workB.getSheetAt(0).getRow(rowCount).getCell(cellCount);
                    String result1 = ParsingExcel.ParsingCell(cell1);

                    if (!result0.equals(result1))
                        cell1.setCellStyle(newStyle);
                } catch (NullPointerException e) {
                   System.out.println(e.getMessage());
                }
            } // for cellCount
        } // for rowCount

        workB.write(fileOutputStreamB);

        fileInputStreamA.close();
        fileInputStreamB.close();
        fileOutputStreamB.close();
    }

    public static String ParsingCell(Cell cell) {
        String result = "";
        switch (cell.getCellType()) {
            case STRING:
                result = cell.getRichStringCellValue().getString();
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

