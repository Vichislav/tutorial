package equation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main  {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //украдено

    public static void main(String[] args) throws IOException
    {
        InputFile.ReadEquationsFromFile("notes4.txt");

        //throws IOException что за ошибки?
        double a = 0.0;
        double b = 0.0;
        double c = 0.0;
        String continueChoice;

        do {

            boolean isValidA = false;
            boolean isValidB = false;
            boolean isValidC = false;

            while (isValidA == false)
            {
                System.out.println("Введите коэффициент [a] уравнения типа ax^2 + bx + c");
                try {
                    a = Integer.parseInt(reader.readLine());
                    isValidA = true;
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }
            while (isValidB == false)
            {
                System.out.println("Введите коэффициент [b] уравнения типа ax^2 + bx + c");
                try {
                    b = Integer.parseInt(reader.readLine());
                    isValidB = true;
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }
            while (isValidC == false)
            {
                System.out.println("Введите коэффициент [c] уравнения типа ax^2 + bx + c");
                try {
                    c = Integer.parseInt(reader.readLine());
                    isValidC = true;
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.print("Ваше уравнение имеет вид? " + a + "*x^2+" + b + "x+" + c + " Y/N:");

            continueChoice = reader.readLine();
        } while (continueChoice.equalsIgnoreCase("N"));

        ArrayList<Double> root = Solver.SolveEquation(a, b, c);
        if (root == null)
            System.out.println("Уравнение не имеет корней");
        else
            for (int i = 0; i < root.size(); i++)
                System.out.printf("корень №" + (i + 1) + " " + root.get(i) + "\n" );
    }
}

