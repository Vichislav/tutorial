package equation;

import javax.xml.transform.SourceLocator;
import java.util.ArrayList;
import java.util.List;

public class Solver {
    //статический метод использует только то что дали на вход
    public static ArrayList<Double> SolveEquation(double a, double b, double c) //расчет дискрименанта D
    {
        ArrayList<Double> root = new ArrayList<Double>();

        double d = Math.pow(b, 2) - 4 * a * c;

        if (d >= 0)
        {
            if (d > 0) {
                root.add((-b - Math.sqrt(d)) / (2 * a));
                root.add((-b + Math.sqrt(d)) / (2 * a));

            }
            else
                root.add(-b / (2 * a));

            return root;
        }
        else
            return null;
    }

}
