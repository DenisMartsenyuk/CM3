package functions;

import java.util.Collections;
import java.util.List;

public class FunctionThird implements Function {
    @Override
    public String getName() {
        return "sin(x)/x";
    }

    @Override
    public double calcValue(double x) {
        return Math.sin(x) / x;
    }

    @Override
    public List<Double> getGaps() {
        return Collections.singletonList(0.0);
    }
}
