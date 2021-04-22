package functions;

import java.util.List;

public class FunctionFirst implements Function {
    @Override
    public String getName() {
        return "2x^3-2x^2+7x-14";
    }

    @Override
    public double calcValue(double x) {
        return 2 * x * x * x - 2 * x * x + 7 * x - 14;
    }

    @Override
    public List<Double> getGaps() {
        return null;
    }
}
