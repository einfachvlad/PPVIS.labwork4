package Controller;

import java.util.LinkedList;

public class ReversePolishNotation {

    boolean isOperator(char operator) {
        return operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '%';
    }

    int priority(char operator) {
        if (operator == '*' || operator == '/' || operator == '%')
            return 1;
        else if (operator == '+' || operator == '-')
            return 0;
        else return -1;
    }

    void runCommand(LinkedList<Double> operands, char operator) {

        double firstOperand = operands.removeLast();
        double secondOperand = operands.removeLast();

        switch (operator) {
            case '+':
                operands.add(firstOperand + secondOperand);
                break;
            case '-':
                operands.add(secondOperand - firstOperand);
                break;
            case '*':
                operands.add(secondOperand * firstOperand);
                break;
            case '/':
                operands.add(secondOperand / firstOperand);
                break;
            case '%':
                operands.add(secondOperand % firstOperand);
                break;
            default:
                System.out.println("Something wrong");
        }
    }

    public double parsing(String string) {

        LinkedList<Double> operands = new LinkedList<>();
        LinkedList<Character> operators = new LinkedList<>();
        boolean minusChecker = true;
        for (int index = 0; index < string.length(); index++) {
            char c = string.charAt(index);
            /*if (c == '-')
                operands.add(0.0);*/

            if (c == '(') {
                operators.add('(');
                minusChecker=true;
            } else if (c == ')') {
                while (operators.getLast() != '(') {
                    runCommand(operands, operators.removeLast());
                }
                operators.removeLast();
            } else if (isOperator(c)) {

                if (c == '-' && minusChecker) {
                    operands.add(0.0);
                    minusChecker = false;
                }

                while (!operators.isEmpty() &&
                        priority(operators.getLast()) >= priority(c)) {
                    runCommand(operands, operators.removeLast());
                }
                operators.add(c);
            } else {
                String operand = "";

                while (index < string.length() &&
                        (Character.isDigit(string.charAt(index)) || string.charAt(index) == '.')) {
                    operand += string.charAt(index++);
                }
                --index;
                operands.add(Double.parseDouble(operand));
            }
        }

        while (!operators.isEmpty()) {
            runCommand(operands, operators.removeLast());
        }
        return operands.get(0);

    }

}
