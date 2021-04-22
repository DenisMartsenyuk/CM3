package solutions;

import functions.Function;

public class SolutionRectangleLeft extends Solution {
    @Override
    public String getName() {
        return "Метод левых прямоугольников";
    }

    @Override
    protected double calcByParameters(Function function, double a, double b) {
        double h = (b - a) / n;
        double result = 0.0;
        for (double x = a; x < b; x += h) {
            result += function.calcValue(x);
        }
        result *= h;
        return result;
    }
}
