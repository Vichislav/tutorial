package equation;

public class oneRoot {

    private double root;

    oneRoot (double a, double b, double c) {
       root = -b/(2*a);
    }

    public double getRoot() {
        return root;
    }
}
