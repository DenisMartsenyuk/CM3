package solutions;

import auxiliary.Interval;
import auxiliary.SolutionResult;
import functions.Function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Solution {
    protected int n = 4;
    public abstract String getName();
    protected abstract double calcByInterval(Function function, Interval interval);

    private List<Interval> getIntervals(Function function, Interval interval) {
        final double  OFFSET = 0.01;

        List<Double> gaps = function.getGaps();
        if (gaps == null) {
            return Collections.singletonList(interval);
        }
        double a = interval.getA();
        double b = interval.getB();
        Collections.sort(gaps);
        List<Interval> intervals = new ArrayList<>();
        double startInterval = a;
        double finalInterval = b;
        for (Double gap : gaps) {
            if (gap < a || gap > b) {
                continue;
            }
            if (gap == a) {
                startInterval = gap + OFFSET;
                continue;
            }
            if (gap == b) {
                finalInterval = b - OFFSET;
                continue;
            }
            intervals.add(new Interval(startInterval, gap - OFFSET));
            startInterval = gap + OFFSET;

        }
        intervals.add(new Interval(startInterval, finalInterval));
        return intervals;
    }

    private double calcSumIntervals(Function function, List<Interval> intervals) {
        double sum = 0.0;
        for (Interval interval : intervals) {
            sum += calcByInterval(function, interval);
        }
        return sum;
    }

    public SolutionResult calc(Function function, Interval fullInterval, double accuracy) {
        List<Interval> intervals = getIntervals(function, fullInterval);
        double prevResult = calcSumIntervals(function, intervals);
        double currentResult = 0;
        while (Math.abs(currentResult - prevResult) > accuracy) { //todo что-то с выходом не так для правого и левого и среднего
            prevResult = currentResult;
            n *= 2;
            currentResult = calcSumIntervals(function, intervals);
        }
        return new SolutionResult(n, currentResult);
    }

}
