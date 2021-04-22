package solutions;

import auxiliary.Interval;
import functions.Function;

public class SolutionRectangleLeft extends Solution {
    @Override
    public String getName() {
        return "Метод левых прямоугольников";
    }

    @Override
    protected double calcByInterval(Function function, Interval interval) {
        double a = interval.getA();
        double b = interval.getB();
        double h = (b - a) / n;
        double result = 0.0;
        for (double x = a; x < b; x += h) {
            result += function.calcValue(x);
        }
        result *= h;
        return result;
    }
}
