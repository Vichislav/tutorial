package equation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

//для логики ввода данных
public class InputFile {
    public static ArrayList<Equation> ReadEquationsFromFile(String filePath)
    {
        //Equation currentEquation = new Equation();

        // Создаем "экземпляр" класса реализующего динамический массив (new ArrayList)
        // объектов типа <Equation>,  ссылку на него передаем в переменную arrayEquation
        // (как мы с ним работаем) ___ (ссылка) = (тип массива)___<тип объектов>
        ArrayList<Equation> equations = new ArrayList<Equation>();

        String lineOfFile;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath)))
        {
            // чтение построчно

            while ((lineOfFile = bufferedReader.readLine()) != null)
            {
                //разделение строки на отдельные подстроки(не пустая связанная часть строки)
                //(критерий, указываем в "", в данном случае пробел)

                Equation currentEquation = new Equation();

                String[] numbers = lineOfFile.split(" "); // то что разделили помещаем в массив numbers типа String

                double a = Double.parseDouble(numbers[0]); //перевод 1 элемента массива numbers в тип double
                double b = Double.parseDouble(numbers[1]); //перевод 2 элемента массива numbers в тип double
                double c = Double.parseDouble(numbers[2]); //перевод 3 элемента массива numbers в тип double

                currentEquation.setA(a); //помещаем "а" в экземпляр класса Equation currentEquation
                currentEquation.setB(b); //-//-
                currentEquation.setC(c);

                equations.add(currentEquation); //помещаем экземпляр класса currentEquation в arrayEquation
                //System.out.println(arrayEquation.get(0));
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }

        return equations;
    }
}


