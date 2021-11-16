package equation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main  {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //украдено

    public static void main(String[] args) throws IOException { //throws IOException что за ошибки?
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

        discriminant firstDiscriminant = new discriminant(a, b, c);
        double d = firstDiscriminant.getDiscriminantRoot();

        System.out.println("Значение дискрименанта составило " + d );

        if  (d < 0) {
            System.out.println("уравнение не имеет корней");
        }
        else if (d == 0) {
            oneRoot firstSolver = new oneRoot(a, b, c);
            double x1 = firstSolver.getRoot();
            System.out.println("уравнение имеем один корень равный " + x1);
        }
        else {
            twoRoot secondSolver = new twoRoot(a, b, c);
            double x1 = secondSolver.getRoot1();
            double x2 = secondSolver.getRoot2();
            System.out.println("уравнение имеем два корня " + "\n" +
                    "первый корень == " + x1 + "\n" +
                    "второй корень == " + x2 );
        }




    }
}
