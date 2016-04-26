package Controller;

import java.util.LinkedList;

public class ReversePolishNotation {

    boolean isOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") || operator.equals("%");
    }

    boolean isTrigonometry(String firstLetter) {
        return firstLetter.equals("s") || firstLetter.equals("c") || firstLetter.equals("t");
    }

    int priority(String operator) {
        if (operator.equals("*") || operator.equals("/") || operator.equals("%"))
            return 1;
        else if (operator.equals("+") || operator.equals("-"))
            return 0;
        else return -1;
    }

    void runCommand(LinkedList<Double> operands, String operator) {

        double firstOperand = operands.removeLast();
        if (operator.equals("sin") || operator.equals("cos") || operator.equals("tan") ||
                operator.equals("sinh") || operator.equals("cosh") || operator.equals("tanh")) {
            switch (operator) {
                case "sin":
                    operands.add(Math.sin(firstOperand));
                    break;
                case "cos":
                    operands.add(Math.cos(firstOperand));
                    break;
                case "tan":
                    operands.add(Math.tan(firstOperand));
                    break;
                case "sinh":
                    operands.add(Math.sinh(firstOperand));
                    break;
                case "cosh":
                    operands.add(Math.cosh(firstOperand));
                    break;
                case "tanh":
                    operands.add(Math.tanh(firstOperand));
                    break;
            }
        } else {
            double secondOperand = operands.removeLast();

            switch (operator) {
                case "+":
                    operands.add(firstOperand + secondOperand);
                    break;
                case "-":
                    operands.add(secondOperand - firstOperand);
                    break;
                case "*":
                    operands.add(secondOperand * firstOperand);
                    break;
                case "/":
                    operands.add(secondOperand / firstOperand);
                    break;
                case "%":
                    operands.add(secondOperand % firstOperand);
                    break;
                default:
                    System.out.println("Something wrong");
            }
        }
    }

    public double parsing(String string) {

        LinkedList<Double> operands = new LinkedList<>();
        LinkedList<String> operators = new LinkedList<>();
        boolean minusChecker = true;
        for (int index = 0; index < string.length(); index++) {
            String c = String.valueOf(string.charAt(index));

            if (c.equals("(")) {
                operators.add("(");
                minusChecker = true;
            } else if (c.equals(")")) {
                while (!operators.getLast().equals("(")) {
                    runCommand(operands, operators.removeLast());
                }
                operators.removeLast();
            } else if (isOperator(c)) {

                if (c.equals("-") && minusChecker)
                    operands.add(0.0);

                while (!operators.isEmpty() &&
                        priority(operators.getLast()) >= priority(c)) {
                    runCommand(operands, operators.removeLast());
                }
                minusChecker = false;
                operators.add(c);
            } else if (isTrigonometry(c)) {

                String subString3 = string.substring(index, index + 3);
                String subString4 = string.substring(index, index + 4);


                if (subString4.equals("sinh")) {
                    operators.add("sinh");
                    index += 3;
                } else if (subString4.equals("cosh")) {
                    operators.add("cosh");
                    index += 3;
                } else if (subString4.equals("tanh")) {
                    operators.add("tanh");
                    index += 3;
                } else if (subString3.equals("sin")) {
                    operators.add("sin");
                    index += 2;
                } else if (subString3.equals("cos")) {
                    operators.add("cos");
                    index += 2;
                } else if (subString3.equals("tan")) {
                    operators.add("tan");
                    index += 2;
                }


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
