package equation;

public class twoRoot extends discriminant{
    private double root1;
    private double root2;

    twoRoot (double a, double b, double c) {
        double d = getDiscriminantRoot();
        root1 = (-b-Math.pow(d,0.5))/2*a;
        root2 = (-b+Math.pow(d,0.5))/2*a;
    }

    public double getRoot1() {
        return root1;
    }
    public double getRoot2() {
        return root2;
    }
}

