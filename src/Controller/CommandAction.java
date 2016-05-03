package Controller;

import View.CalculatorParts.*;
import View.TreePanel;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

public class CommandAction implements ActionListener {
    JButton button;
    Screen screen;
    TreePanel tree;
    ReversePolishNotation reversePolishNotation;
    String value;
    DefaultMutableTreeNode child;
    DefaultMutableTreeNode parent;

    public CommandAction(JButton button, Screen screen, TreePanel tree) {
        this.button = button;
        this.screen = screen;
        this.tree = tree;

        reversePolishNotation = new ReversePolishNotation(tree);
    }

    public void actionPerformed(ActionEvent event) {

        String input = event.getActionCommand();
        switch (button.getText()) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                screen.getScreen().setText(screen.getScreen().getText() + input);
                break;
            case "sin":
            case "cos":
            case "tan":
            case "sinh":
            case "cosh":
            case "tanh":
                screen.getScreen().setText(screen.getScreen().getText() + input + "(");
                break;
            case "=":
                try {
                    screen.getScreen().setText(String.valueOf(reversePolishNotation.parsing(screen.getScreen().getText())));
                    tree.update();
                } catch (NumberFormatException e) {
                } catch (IndexOutOfBoundsException e) {
                } catch (NoSuchElementException e) {
                }
                break;
            case "C":
                screen.getScreen().setText("");
                tree.getRoot().removeAllChildren();
                tree.getRoot().setUserObject("=");
                tree.update();
                reversePolishNotation.resetNotation();
                break;
            case "DEL":
                try {
                    screen.getScreen().setText(screen.getScreen().getText().substring(0, screen.getScreen().getText().length() - 1));
                } catch (StringIndexOutOfBoundsException e) {
                }
                break;
            case "sqrt":
                value = String.valueOf(Math.sqrt(Double.parseDouble(screen.getScreen().getText())));
                screen.getScreen().setText(value);
                tree.getRoot().setUserObject(value);

                child = tree.getRoot().getNextNode();
                parent = new DefaultMutableTreeNode("sqrt");
                parent.add(child);
                tree.getRoot().removeAllChildren();
                tree.getRoot().add(parent);
                tree.update();
                break;
            case "1/x":
                try {
                    value = String.valueOf(1 / Double.parseDouble(screen.getScreen().getText()));
                    screen.getScreen().setText(value);
                    tree.getRoot().setUserObject(value);

                    child = tree.getRoot().getNextNode();
                    parent = new DefaultMutableTreeNode("1/x");
                    parent.add(child);
                    tree.getRoot().removeAllChildren();
                    tree.getRoot().add(parent);
                    tree.update();

                } catch (NumberFormatException e) {
                }
                break;
        }
    }
}

