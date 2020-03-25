package by.academy.HomeWork1.task1;

public interface ICalculator {
    double getSum(double summand1, double summand2);

    double getDifference(double minuend, double subtrahend);

    double getProduct(double multiplier1, double multiplier2);

    double getQuotient(double dividend, double divisor);

    double raiseToPower(double base, int exponent);

    double getModule(double i);

    double extractRoot(double i);
}
