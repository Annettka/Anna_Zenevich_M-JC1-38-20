package by.academy.HomeWork1.task1;

public class Main3 {
    public static void main(String[] args) throws Exception {
        CalculatorStringExpression calc = new CalculatorStringExpression();

        String str = "4.1 + 15 * 7 + (28 / 5) ^ 2";
        double res = calc.evaluate(str);
        System.out.println(res);
    }
}

