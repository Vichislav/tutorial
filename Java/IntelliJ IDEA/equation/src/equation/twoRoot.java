package equation;

public class twoRoot {
    private double root1;
    private double root2;

    twoRoot (double a, double b, double c) {
        double d = Math.pow(b,2)-4*a*c;
        root1 = (-b - Math.sqrt(d)) / (2 * a);
        root2 = (-b + Math.sqrt(d)) / (2 * a);
        System.out.println("math.sqrt == " + Math.sqrt(4.0));
    }

    public double getRoot1() {
        return root1;
    }
    public double getRoot2() {
        return root2;
    }
}

