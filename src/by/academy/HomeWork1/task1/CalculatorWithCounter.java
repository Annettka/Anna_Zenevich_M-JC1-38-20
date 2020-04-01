package by.academy.HomeWork1.task1;

public class CalculatorWithCounter implements ICalculator {
    private ICalculator calc;
    private int countOperation;

    public CalculatorWithCounter(ICalculator calc) {
        this.calc = calc;
    }

    public int getCountOperation() {
        return countOperation;
    }

    @Override
    public double getSum(double summand1, double summand2) {
        this.countOperation++;
        return calc.getSum(summand1, summand2);
    }

    @Override
    public double getDifference(double minuend, double subtrahend) {
        this.countOperation++;
        return calc.getDifference(minuend, subtrahend);
    }

    @Override
    public double getProduct(double multiplier1, double multiplier2) {
        this.countOperation++;
        return calc.getProduct(multiplier1, multiplier2);
    }

    @Override
    public double getQuotient(double dividend, double divisor) {
        this.countOperation++;
        return calc.getQuotient(dividend, divisor);
    }

    @Override
    public double raiseToPower(double base, int exponent) {
        this.countOperation++;
        return calc.raiseToPower(base, exponent);
    }

    @Override
    public double getModule(double i) {
        this.countOperation++;
        return calc.getModule(i);
    }

    @Override
    public double extractRoot(double i) {
        this.countOperation++;
        return calc.extractRoot(i);
    }
}
