package by.academy.HomeWork1.task1;

public class CalculatorStringExpression {

    final int NONE = 0;
    final int DELIMITER = 1;
    final double NUMBER = 2;
    final double PI = 3.14;
    final double E = 2.718;

    final int SYNTAXERROR = 0;
    final int UNBALPARENS = 1; //not closed parentheses
    final int NOEXP = 2;       //no expression
    final int DIVBYZERO = 3;   //div by zero
    final String EOF = "\0";   //end of expr

    private String exp;
    private int currIndex;
    private String token;
    private double tokType;

    private void getToken() {
        tokType = NONE;
        token = "";

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
                if (currIndex >= exp.length()) {
                    break;
                }
            }
            tokType = NUMBER;
        } else if (Character.isLetter(exp.charAt(currIndex))) {
            while (!isDelim(exp.charAt(currIndex))) {
                token += exp.charAt(currIndex);
                currIndex++;
                if (currIndex >= exp.length()) {
                    break;
                }
            }
            if ("PI".equalsIgnoreCase(token)) {
                tokType = PI;
            } else if ("E".equalsIgnoreCase(token)) {
                tokType = E;
            }
        } else {
            token = EOF;
            return;
        }
    }

    private boolean isDelim(char charAt) {
        return (("+-/*^=()".indexOf(charAt)) != -1) ? true : false;
    }

    //  Enter point
    public double evaluate(String expr) throws Exception {
        double result;
        exp = expr.replace(" ", "");
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
        while ((op = token.charAt(0)) == '*' || op == '/') {
            getToken();
            partialResult = evalRaiseToPow();
            switch (op) {
                case '*':
                    result *= partialResult;
                    break;
                case '/':
                    if (partialResult == 0.0) {
                        handleErr(DIVBYZERO);
                    }
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
                for (t = (int) partialResult - 1; t > 0; t--) {
                    result *= exp;
                }
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
        if (op.equals("-")) {
            result = -result;
        }
        return result;
    }

    private double evalParentExp() throws Exception {
        double result;

        if (token.equals("(")) {
            getToken();
            result = evalPlusMinus();
            if (!token.equals(")")) {
                handleErr(UNBALPARENS);
            }
            getToken();
        } else {
            result = getValue();
        }
        return result;
    }

    private double getValue() throws Exception {
        double result = 0.0;
        if (tokType == NUMBER) {
            try {
                result = Double.parseDouble(token);
            } catch (NumberFormatException exc) {
                handleErr(SYNTAXERROR);
            }
            getToken();
        } else if (tokType == PI) {
            result = PI;
            getToken();
        } else if (tokType == E) {
            result = E;
            getToken();
        } else {
            handleErr(SYNTAXERROR);
        }
        return result;
    }

    private void handleErr(int nOEXP2) throws Exception {
        String[] err = {"Syntax error", "Unbalanced Parentheses",
                "No Expression Present", "Division by zero"};
        throw new Exception(err[nOEXP2]);
    }
}
