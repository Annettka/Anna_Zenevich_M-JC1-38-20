package by.academy.HomeWork1.task1;

public class CalculatorStringExpression implements ICalculator {

    private double currentState;
    private String restExpression;

    public void getResult(double v, String r) {
        this.currentState = v;
        this.restExpression = r;
    }






    @Override
    public double getSum(double summand1, double summand2) {
        return 0;
    }

    @Override
    public double getDifference(double minuend, double subtrahend) {
        return 0;
    }

    @Override
    public double getProduct(double multiplier1, double multiplier2) {
        return 0;
    }

    @Override
    public double getQuotient(double dividend, double divisor) {
        return 0;
    }

    @Override
    public double raiseToPower(double base, int exponent) {
        return 0;
    }

    @Override
    public double getModule(double i) {
        return 0;
    }

    @Override
    public double extractRoot(double i) {
        return 0;
    }
}
