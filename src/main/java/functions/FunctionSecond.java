package functions;

import java.util.Collections;
import java.util.List;

public class FunctionSecond implements Function {
    @Override
    public String getName() {
        return "1/x";
    }

    @Override
    public double calcValue(double x) {
        return 1.0 / x;
    }

    @Override
    public List<Double> getGaps() {
        return Collections.singletonList(0.0);
    }
}
