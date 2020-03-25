package by.academy.HomeWork1.task1;

public class CalculatorWithOperator implements ICalculator {
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
        double result = base;
        if (exponent == 0) {
            result = 1;
        } else if (exponent == (-1)) {
            result = 1 / base;
        } else if (exponent > 1) {
            for (int i = 1; i < exponent; i++) {
                result *= base;
            }
        } else if (exponent < (-1)) {
            for (int i = 1; i < (exponent * (-1)); i++) {
                result *= base;
            }
            result = 1 / result;
        }
            return result;
        }

        public double getModule ( double i){
            return i < 0 ? (-1 * i) : i;
        }

        public double extractRoot ( double i){
            return Math.sqrt(i);
        }
    }
