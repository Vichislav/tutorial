package reader;

import java.io.*;



public class Main {
    public static void main(String[] args) {
        try {
            ParsingExcel.EqualExcelFiles("test.xls", "test_1.xls");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
