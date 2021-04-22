package solutions;

import auxiliary.SolutionResult;
import functions.Function;

public abstract class Solution {
    protected int n = 4;
    public abstract String getName();
    protected abstract double calcByParameters(Function function, double a, double b);
    public SolutionResult calc(Function function, double a, double b, double accuracy) {
        double prevResult = calcByParameters(function, a, b);
        double currentResult = 0;
        while (Math.abs(currentResult - prevResult) > accuracy) { //todo что-то с выходом не так для правого и левого и среднего
            prevResult = currentResult;
            n *= 2;
            currentResult = calcByParameters(function, a, b);
        }
        return new SolutionResult(n, currentResult);
    }

}
