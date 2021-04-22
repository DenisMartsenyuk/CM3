package solutions;

import functions.Function;

public class SolutionTrapezoid extends Solution {

    @Override
    public String getName() {
        return "Метод трапеций";
    }

    @Override
    protected double calcByParameters(Function function, double a, double b) {
        double h = (b - a) / n;
        double result = function.calcValue(a) + function.calcValue(b);
        for (double x = a + h; x < b; x += h) {
            result += 2 * function.calcValue(x);
        }
        result *= (h / 2);
        return result;
    }

}
