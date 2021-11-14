package adapters;

import round.RoundPeg;
import square.SquarePeg;

/**
 * Адаптер позволяет использовать КвадратныеКолышки и КруглыеОтверстия вместе.
 */
public class SquarePegAdapter extends RoundPeg {
    private SquarePeg peg; //обьявлем поле peg типа SquarePeg

    public SquarePegAdapter(SquarePeg peg) { // peg - ссылка, SquarePeg - её тип
        this.peg = peg; //закидываем peg  в приватное поле private SquarePeg peg
    }

    @Override
    public double getRadius() {
        double result;
        // Рассчитываем минимальный радиус, в который пролезет этот колышек. Math.sqrt - извлечение корня
        result = (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
        return result;
    }
}