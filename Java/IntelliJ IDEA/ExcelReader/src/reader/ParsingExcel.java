package reader;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public final class ParsingExcel {
    public static void EqualExcelFiles(String filePath1, String filePath2) throws IOException {

        FileInputStream fileInputStreamA = new FileInputStream(filePath1);
        Workbook workbookA = new HSSFWorkbook(fileInputStreamA);



        FileInputStream fileInputStreamB = new FileInputStream(filePath2);
        Workbook workbookB = new HSSFWorkbook(fileInputStreamB);

        FileOutputStream fileOutputStreamB = new FileOutputStream(filePath2);

        CellStyle newStyle = workbookB.createCellStyle();
        newStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
        newStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);


        for (int rowCount = 0; rowCount < workbookA.getSheetAt(0).getPhysicalNumberOfRows(); rowCount++) {
            for (int cellCount = 0; cellCount < workbookA.getSheetAt(0).getRow(rowCount).getPhysicalNumberOfCells(); cellCount++) {
                try {
                    Cell cell0 = workbookA.getSheetAt(0).getRow(rowCount).getCell(cellCount);
                    String result0 = ParsingExcel.ParsingCell(cell0);

                    Cell cell1 = workbookB.getSheetAt(0).getRow(rowCount).getCell(cellCount);
                    String result1 = ParsingExcel.ParsingCell(cell1);

                    if (!result0.equals(result1))
                        cell1.setCellStyle(newStyle);

                } catch (NullPointerException e) {
                   //System.out.println(e.getMessage());
                }
            }
        }
        workbookB.write(fileOutputStreamB);

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

