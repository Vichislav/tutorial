package equation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main  {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //украдено

    public static void main(String[] args) throws IOException
    { //throws IOException что за ошибки?
        double a;
        double b;
        double c;
        String continueChoice;

        do {
            System.out.println("Введите коэффициент [a] уравнения типа ax^2 + bx + c");
            a = Integer.parseInt(reader.readLine());

            System.out.println("Введите коэффициент [b] уравнения типа ax^2 + bx + c");
            b = Integer.parseInt(reader.readLine());

            System.out.println("Введите коэффициент [c] уравнения типа ax^2 + bx + c");
            c = Integer.parseInt(reader.readLine());

            System.out.print("Ваше уравнение имеет вид? " + a + "*x^2+" + b + "x+" + c + " Y/N:");

            continueChoice = reader.readLine();
        } while (continueChoice.equalsIgnoreCase("N"));

        ArrayList<Double> root = Solver.SolveEquation(a, b, c);
        // вывод с помощью массива + забор данных из файла
        for (int i = 0; i < root.size(); i++)
            System.out.printf("корень №" + (i + 1) + " " + root.get(i) + "\n" );
    }
}

