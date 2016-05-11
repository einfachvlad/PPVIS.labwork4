package Controller;

import View.Tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.LinkedList;

public class ReversePolishNotation {

    DefaultMutableTreeNode child1;
    DefaultMutableTreeNode child2;
    DefaultMutableTreeNode parent;
    Tree tree;
    DefaultMutableTreeNode laterNode;

    public ReversePolishNotation(Tree tree) {
        this.tree = tree;
        child1 = new DefaultMutableTreeNode();
        child2 = new DefaultMutableTreeNode();
        parent = new DefaultMutableTreeNode("");
        laterNode = new DefaultMutableTreeNode("");
    }

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
        String expression;
        if (operator.equals("sin") || operator.equals("cos") || operator.equals("tan") ||
                operator.equals("sinh") || operator.equals("cosh") || operator.equals("tanh")) {

            if (parent.getChildCount() == 0)
                child1 = new DefaultMutableTreeNode(firstOperand);
            else
                child1 = parent;


            switch (operator) {
                case "sin":
                    operands.add(Math.sin(firstOperand));
                    parent = new DefaultMutableTreeNode(Math.sin(firstOperand));
                    parent.add(child1);
                    tree.getRoot().removeAllChildren();
                    tree.getRoot().add(parent);

                    expression = tree.getExpressions().getLast().replace("sin(" + firstOperand + ")", parent.toString());
                    tree.getExpressions().add(expression);

                    break;
                case "cos":
                    operands.add(Math.cos(firstOperand));
                    parent = new DefaultMutableTreeNode(Math.cos(firstOperand));
                    parent.add(child1);
                    tree.getRoot().removeAllChildren();
                    tree.getRoot().add(parent);

                    expression = tree.getExpressions().getLast().replace("cos(" + firstOperand + ")", parent.toString());
                    tree.getExpressions().add(expression);

                    break;
                case "tan":
                    operands.add(Math.tan(firstOperand));
                    parent = new DefaultMutableTreeNode(Math.tan(firstOperand));
                    parent.add(child1);
                    tree.getRoot().removeAllChildren();
                    tree.getRoot().add(parent);

                    expression = tree.getExpressions().getLast().replace("tan(" + firstOperand + ")", parent.toString());
                    tree.getExpressions().add(expression);

                    break;
                case "sinh":
                    operands.add(Math.sinh(firstOperand));
                    parent = new DefaultMutableTreeNode(Math.sinh(firstOperand));
                    parent.add(child1);
                    tree.getRoot().removeAllChildren();
                    tree.getRoot().add(parent);

                    expression = tree.getExpressions().getLast().replace("sinh(" + firstOperand + ")", parent.toString());
                    tree.getExpressions().add(expression);

                    break;
                case "cosh":
                    operands.add(Math.cosh(firstOperand));
                    parent = new DefaultMutableTreeNode(Math.cosh(firstOperand));
                    parent.add(child1);
                    tree.getRoot().removeAllChildren();
                    tree.getRoot().add(parent);

                    expression = tree.getExpressions().getLast().replace("cosh(" + firstOperand + ")", parent.toString());
                    tree.getExpressions().add(expression);

                    break;
                case "tanh":
                    operands.add(Math.tanh(firstOperand));
                    parent = new DefaultMutableTreeNode(Math.tanh(firstOperand));
                    parent.add(child1);
                    tree.getRoot().removeAllChildren();
                    tree.getRoot().add(parent);

                    expression = tree.getExpressions().getLast().replace("tanh(" + firstOperand + ")", parent.toString());
                    tree.getExpressions().add(expression);

                    break;
            }
        } else {

            double secondOperand = operands.removeLast();

            if (!laterNode.getUserObject().equals("")) {
                if (firstOperand == Double.valueOf(laterNode.toString())) {
                    child1 = laterNode;
                    child2 = new DefaultMutableTreeNode(secondOperand);
                    laterNode = new DefaultMutableTreeNode();
                } else if (secondOperand == Double.valueOf(laterNode.toString())) {
                    child2 = laterNode;
                    child1 = new DefaultMutableTreeNode(firstOperand);
                    laterNode = new DefaultMutableTreeNode();
                }
            } else {
                if (parent.getChildCount() == 0) {
                    child1 = new DefaultMutableTreeNode(firstOperand);
                    child2 = new DefaultMutableTreeNode(secondOperand);
                } else {

                    if (firstOperand == Double.valueOf(parent.toString())) {
                        child1 = parent;
                        child2 = new DefaultMutableTreeNode(secondOperand);
                    } else if (secondOperand == Double.valueOf(parent.toString())) {
                        child2 = parent;
                        child1 = new DefaultMutableTreeNode(firstOperand);
                    } else {
                        laterNode = parent;
                        child1 = new DefaultMutableTreeNode(firstOperand);
                        child2 = new DefaultMutableTreeNode(secondOperand);
                    }

                }
            }
            switch (operator) {
                case "+":
                    operands.add(firstOperand + secondOperand);

                    parent = new DefaultMutableTreeNode(firstOperand + secondOperand);

                    parent.add(child1);
                    parent.add(child2);

                    tree.getRoot().removeAllChildren();
                    tree.getRoot().add(parent);

                    String exp = firstOperand + "+" + secondOperand;
                    expression = tree.getExpressions().getLast().replace(secondOperand + "+" + firstOperand, parent.toString());
                    if (expression.equals(tree.getExpressions().getLast())) {
                        expression = tree.getExpressions().getLast().replace("(" + secondOperand + ")" + "+" + firstOperand, parent.toString());
                        if (expression.equals(tree.getExpressions().getLast()))
                            tree.getExpressions().add(expression);
                        else {
                            expression = tree.getExpressions().getLast().replace(+secondOperand + "+" + "(" + firstOperand + ")", parent.toString());
                            tree.getExpressions().add(expression);

                        }
                    } else
                        tree.getExpressions().add(expression);

                    break;
                case "-":
                    operands.add(secondOperand - firstOperand);

                    parent = new DefaultMutableTreeNode(secondOperand - firstOperand);
                    if (secondOperand != 0.0 && firstOperand != 0.0) {
                        parent.add(child1);
                        parent.add(child2);
                    }

                    tree.getRoot().removeAllChildren();
                    tree.getRoot().add(parent);

                    expression = tree.getExpressions().getLast().replace(secondOperand + "-" + firstOperand, parent.toString());
                    if (expression.equals(tree.getExpressions().getLast())) {
                        expression = tree.getExpressions().getLast().replace("(" + secondOperand + ")" + "-" + firstOperand, parent.toString());
                        if (expression.equals(tree.getExpressions().getLast()))
                            tree.getExpressions().add(expression);
                        else {
                            expression = tree.getExpressions().getLast().replace(+secondOperand + "-" + "(" + firstOperand + ")", parent.toString());
                            tree.getExpressions().add(expression);
                        }
                    } else
                        tree.getExpressions().add(expression);

                    break;
                case "*":
                    operands.add(secondOperand * firstOperand);

                    parent = new DefaultMutableTreeNode(firstOperand * secondOperand);

                    parent.add(child1);
                    parent.add(child2);

                    tree.getRoot().removeAllChildren();
                    tree.getRoot().add(parent);

                    expression = tree.getExpressions().getLast().replace(secondOperand + "*" + firstOperand, parent.toString());
                    tree.getExpressions().add(expression);

                    break;
                case "/":
                    operands.add(secondOperand / firstOperand);

                    parent = new DefaultMutableTreeNode(secondOperand / firstOperand);

                    parent.add(child1);
                    parent.add(child2);

                    tree.getRoot().removeAllChildren();
                    tree.getRoot().add(parent);

                    expression = tree.getExpressions().getLast().replace(secondOperand + "/" + firstOperand, parent.toString());
                    tree.getExpressions().add(expression);

                    break;
                case "%":
                    operands.add(secondOperand % firstOperand);

                    parent = new DefaultMutableTreeNode(secondOperand % firstOperand);

                    parent.add(child1);
                    parent.add(child2);

                    tree.getRoot().removeAllChildren();
                    tree.getRoot().add(parent);

                    expression = tree.getExpressions().getLast().replace(secondOperand + "%" + firstOperand, parent.toString());
                    tree.getExpressions().add(expression);

                    break;
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
                minusChecker = false;

            }
        }

        while (!operators.isEmpty()) {
            runCommand(operands, operators.removeLast());
        }
        tree.getRoot().setUserObject(operands.get(0));

        DefaultMutableTreeNode newRoot = tree.getRoot().getNextNode();
        //tree.setRoot(newRoot);

/*
        DefaultMutableTreeNode newRoot = tree.getRoot().getNode().getNextNode();
        newRoot.removeFromParent();
        TreeNode root=new TreeNode(newRoot);
        tree.setRoot(root);*/

        return operands.get(0);

    }

}
