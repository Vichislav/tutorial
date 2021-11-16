package equation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main  {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //украдено

    public static void main(String[] args) throws IOException { //throws IOException что за ошибки?

        String continueChoice;

        do {
            System.out.println("Введите коэффициент [a] уравнения типа ax^2 + bx + c");
            int a = Integer.parseInt(reader.readLine());

            System.out.println("Введите коэффициент [b] уравнения типа ax^2 + bx + c");
            int b = Integer.parseInt(reader.readLine());

            System.out.println("Введите коэффициент [c] уравнения типа ax^2 + bx + c");
            int c = Integer.parseInt(reader.readLine());

            System.out.print("Ваше уравнение имеет вид? " + a + "*x^2+" + b + "x+" + c + " Y/N:");

            continueChoice = reader.readLine();
        } while (continueChoice.equalsIgnoreCase("N"));


    }
}
