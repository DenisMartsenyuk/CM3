package solutions;

import auxiliary.Interval;
import functions.Function;

public class SolutionTrapezoid extends Solution {

    @Override
    public String getName() {
        return "Метод трапеций";
    }

    @Override
    protected double calcByInterval(Function function, Interval interval) {
        double a = interval.getA();
        double b = interval.getB();
        double h = (b - a) / n;
        double result = function.calcValue(a) + function.calcValue(b);
        for (double x = a + h; x < b; x += h) {
            result += 2 * function.calcValue(x);
        }
        result *= (h / 2);
        return result;
    }

}
