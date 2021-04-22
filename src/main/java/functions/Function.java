package functions;

import java.util.List;

public interface Function {
    String getName();
    double calcValue(double x);
    List<Double> getGaps();
}
