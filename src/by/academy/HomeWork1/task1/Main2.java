package by.academy.HomeWork1.task1;

public class Main2 {
    public static void main(String[] args) {
        ICalculator calc1 = new CalculatorWithCounter(new CalculatorWithMath());
        ICalculator calc2 = new CalculatorWithCounter(new CalculatorWithOperator());

        System.out.println(calc1.getSum(4.1, calc1.getSum(calc1.getProduct(15, 7), calc1.raiseToPower(calc1.getQuotient(28, 5), 2))));
        System.out.println(calc2.getSum(4.1, calc2.getSum(calc2.getProduct(15, 7), calc2.raiseToPower(calc2.getQuotient(28, 5), 2))));
    }
}
