package equation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

//для логики ввода данных
public class InputFile {
    public static void ReadEquationsFromFile(String filePath)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            //чтение построчно
            String s;
            while ((s = br.readLine()) != null) {

                System.out.println(s);
                //разделение строки на отдельные подстроки(не пустая связанная часть строки)
                //(критерий, указываем в "", в данном случае пробел)
                String[] numbers = s.split(" ");
                double a = Double.parseDouble(numbers[0]);
                double b = Double.parseDouble(numbers[1]);
                double c = Double.parseDouble(numbers[2]);
                double sum = a + b + c;
                System.out.println(a + " + " + b + " + " + c + " = " + sum);
                System.out.println("s.length() == " + s.length());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}


