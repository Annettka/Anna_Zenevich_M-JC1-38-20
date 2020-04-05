package by.academy.HomeWork1.task1;

public class CalculatorStringExpression {

    final int NONE = 0;         //  FAIL
    final int DELIMITER = 1;    //  Разделитель(+-*/^=, ")", "(" )
    final int NUMBER = 3;       //  Число

    //  Объявление констант синтаксических ошибок
    final int SYNTAXERROR = 0;  //  Синтаксическая ошибка (10 + 5 6 / 1)
    final int UNBALPARENS = 1;  //  Несовпадение количества открытых и закрытых скобок
    final int NOEXP = 2;        //  Отсутствует выражение при запуске анализатора
    final int DIVBYZERO = 3;    //  Ошибка деления на ноль

    //  Лексема, определяющая конец выражения
    final String EOF = "\0";

    private String exp;     //  Ссылка на строку с выражением
    private int currIndex;     //  Текущий индекс в выражении
    private String token;   //  Сохранение текущей лексемы
    private int tokType;    //  Сохранение типа лексемы

    private void getToken() {
        tokType = NONE;
        token = "";

        if (currIndex == exp.length()) {
            token = EOF;
            return;
        }
        while (currIndex < exp.length() && Character.isWhitespace(exp.charAt(currIndex))) {
            ++currIndex;
        }
        if (currIndex == exp.length()) {
            token = EOF;
           return;
        }
        if (isDelim(exp.charAt(currIndex))) {
            token += exp.charAt(currIndex);
            currIndex++;
            tokType = DELIMITER;
        } else if (Character.isDigit(exp.charAt(currIndex))) {
            while (!isDelim(exp.charAt(currIndex))) {
                token += exp.charAt(currIndex);
                currIndex++;
                if (currIndex >= exp.length())
                    break;
            }
            tokType = NUMBER;
        } else {
            token = EOF;
            return;
        }
    }

    private boolean isDelim(char charAt) {
        return (("+-/*^=()".indexOf(charAt)) != -1) ? true : false;
    }

    //  Точка входа
    public double evaluate(String expr) throws Exception {
        double result;
        exp = expr;
        currIndex = 0;
        getToken();

        if (token.equals(EOF)) {
            handleErr(NOEXP);
        }
        result = evalPlusMinus();

        if (!token.equals(EOF)) {
            handleErr(SYNTAXERROR);
        }
        return result;
    }

    private double evalPlusMinus() throws Exception {
        char op;
        double result;
        double partialResult;
        result = evalMultDiv();
        while ((op = token.charAt(0)) == '+' || op == '-') {
            getToken();
            partialResult = evalMultDiv();
            switch (op) {
                case '-':
                    result -= partialResult;
                    break;
                case '+':
                    result += partialResult;
                    break;
            }
        }
        return result;
    }

    private double evalMultDiv() throws Exception {
        char op;
        double result;
        double partialResult;

        result = evalRaiseToPow();
        while ((op = token.charAt(0)) == '*' ||
                op == '/' | op == '%') {
            getToken();
            partialResult = evalRaiseToPow();
            switch (op) {
                case '*':
                    result *= partialResult;
                    break;
                case '/':
                    if (partialResult == 0.0)
                        handleErr(DIVBYZERO);
                    result /= partialResult;
                    break;
            }
        }
        return result;
    }

    private double evalRaiseToPow() throws Exception {
        double result;
        double partialResult;
        double exp;
        int t;
        result = evalUnaryOp();
        if (token.equals("^")) {
            getToken();
            partialResult = evalRaiseToPow();
            exp = result;
            if (partialResult == 0.0) {
                result = 1.0;
            } else
                for (t = (int) partialResult - 1; t > 0; t--)
                    result *= exp;
        }
        return result;
    }

    private double evalUnaryOp() throws Exception {
        double result;
        String op;
        op = " ";

        if ((tokType == DELIMITER) && token.equals("+") || token.equals("-")) {
            op = token;
            getToken();
        }
        result = evalParentExp();
        if (op.equals("-"))
            result = -result;
        return result;
    }

    private double evalParentExp() throws Exception {
        double result;

        if (token.equals("(")) {
            getToken();
            result = evalPlusMinus();
            if (!token.equals(")"))
                handleErr(UNBALPARENS);
            getToken();
        } else
            result = getValue();
        return result;
    }

    private double getValue() throws Exception {
        double result = 0.0;
        switch (tokType) {
            case NUMBER:
                try {
                    result = Double.parseDouble(token);
                } catch (NumberFormatException exc) {
                    handleErr(SYNTAXERROR);
                }
                getToken();
                break;
            default:
                handleErr(SYNTAXERROR);
                break;
        }
        return result;
    }

    //  Кинуть ошибку
    private void handleErr(int nOEXP2) throws Exception {
        String[] err = {"Syntax error", "Unbalanced Parentheses",
                "No Expression Present", "Division by zero"};

        throw new Exception(err[nOEXP2]);
    }

    /*    private double currentState;
        private String restExpression;

        public void getResult(double v, String r) {
            this.currentState = v;
            this.restExpression = r;

            4.1 + 15 * 7 + (28 / 5) ^ 2
        }*/

/*

    public static double eval(String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }*/


}
