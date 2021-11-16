package equation;

public class discriminant {
    private double discriminantRoot;

    discriminant (double a, double b, double c) {
        discriminantRoot = Math.pow(b,2)-4*a*c;

    }

    public discriminant() { // пришлось добавить потому как, когда делал наследование дало ошибку
    }

    public double getDiscriminantRoot() {
        return discriminantRoot;
    }
}
