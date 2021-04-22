package solutions;

import functions.Function;

public class SolutionRectangleMiddle extends Solution {

    @Override
    public String getName() {
        return "Метод средних прямоугольников";
    }

    @Override
    protected double calcByParameters(Function function, double a, double b) {
        double h = (b - a) / n;
        double result = 0.0;
        for (double x = a + (h / 2); x < b; x += h) {
            result += function.calcValue(x);
        }
        result *= h;
        return result;
    }
}
