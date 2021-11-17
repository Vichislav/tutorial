package equation;

import javax.xml.transform.SourceLocator;

public class Solver {

    //double discriminant;
    //double root1;
    //double root2;

    Solver (double a, double b, double c) {} //конструктор класса


    public static double[] getDiscriminant(double a, double b, double c) //расчет дискрименанта D
    {
        double[] result = new double[2];

        double d = Math.pow(b, 2) - 4 * a * c;

        if (d >= 0)
        {
            result[0] = (-b - Math.sqrt(d)) / (2 * a);
            result[1] = (-b + Math.sqrt(d)) / (2 * a);

            return result;
        }
        else
            return null;
    }

    public double oneRoot (double a, double b, double c) // расчет единственного корня когда D==0
    {
        double root1 = -b/(2*a);
        return root1;
    }

    public double twoRootFirs (double a, double b, double c) // расчет первого корня когда D>0
    {
        double d = Math.pow(b,2) - 4 * a * c;
        double root1 = (-b - Math.sqrt(d)) / (2 * a);
        return root1;
    }
    public double twoRootSecond (double a, double b, double c) //расчет второго корня когда D>0
    {
        double d = Math.pow(b,2) - 4 * a * c;
        double root2 = (-b + Math.sqrt(d)) / (2 * a);
        return root2;
    }

    public double solverStart ( ) {
        double d = getDiscriminant();
        System.out.println("Значение дискрименанта составило " + discriminant );

        if  (discriminant < 0) {
            System.out.println("уравнение не имеет корней");
        }
        else if (discriminant == 0) {
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
