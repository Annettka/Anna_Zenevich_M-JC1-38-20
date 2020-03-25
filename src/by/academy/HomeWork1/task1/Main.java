package by.academy.HomeWork1.task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CalculatorWithOperator calc = new CalculatorWithOperator();
        double x = calc.getSum(4.1, calc.getSum(calc.getProduct(15, 7), calc.raiseToPower(calc.getQuotient(28, 5), 2)));
        System.out.printf("%.3f %n", x);
//        System.out.printf("%.3f %n", (x / 0)); // Error: Infinity
//        System.out.printf("%.3f %n", (x / 0.0d)); // Error: Infinity
        System.out.println(calc.getModule(-19));
    }
}
