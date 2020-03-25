package by.academy.HomeWork1.task1;

public class CalculatorWithMath implements ICalculator{
    @Override
    public double getSum(double summand1, double summand2) {
        return summand1 + summand2;
    }

    public double getDifference(double minuend, double subtrahend) {
        return minuend - subtrahend;
    }

    public double getProduct(double multiplier1, double multiplier2) {
        return multiplier1 * multiplier2;
    }

    public double getQuotient(double dividend, double divisor) {
        return dividend / divisor;
    }

    public double raiseToPower(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    public double getModule(double i) {
        return Math.abs(i);
    }

    public double extractRoot(double i) {
        return Math.sqrt(i);
    }
}
