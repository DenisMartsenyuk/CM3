package solutions;

import functions.Function;

public class SolutionSimpson extends Solution {

    @Override
    public String getName() {
        return "Метод Симпсона";
    }

    @Override
    protected double calcByParameters(Function function, double a, double b) {
        double h = (b - a) / n;
        double result = function.calcValue(a) + function.calcValue(b);

        for (double x = a + h; x < b; x += (2 * h)) {
            result += 4 * function.calcValue(x);
        }

        for (double x = a + h + h; x < b; x += (2 * h)) {
            result += 2 * function.calcValue(x);
        }
        result *= (h / 3);
        return result;
    }

}
