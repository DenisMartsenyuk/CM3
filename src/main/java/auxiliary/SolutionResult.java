package auxiliary;

public class SolutionResult {
    private int n;
    private double result;

    public SolutionResult(int n, double result) {
        this.n = n;
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public int getN() {
        return n;
    }
}
