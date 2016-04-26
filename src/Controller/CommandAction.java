package Controller;

import View.CalculatorParts.Screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.util.NoSuchElementException;

public class CommandAction implements ActionListener {
    JButton button;
    Screen screen;
    ReversePolishNotation reversePolishNotation;

    public CommandAction(JButton button, Screen screen) {
        this.button = button;
        this.screen = screen;

        reversePolishNotation = new ReversePolishNotation();
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
                } catch (NumberFormatException e) {
                } catch (IndexOutOfBoundsException e) {
                } catch (NoSuchElementException e) {
                }
                break;
            case "C":
                screen.getScreen().setText("");
                break;
            case "DEL":
                try {
                    screen.getScreen().setText(screen.getScreen().getText().substring(0, screen.getScreen().getText().length() - 1));
                } catch (StringIndexOutOfBoundsException e) {
                }
                break;
            case "sqrt":
                screen.getScreen().setText(String.valueOf(Math.sqrt(Double.parseDouble(screen.getScreen().getText()))));
                break;
            case "1/x":
                try {
                    screen.getScreen().setText(String.valueOf(1 / Double.parseDouble(screen.getScreen().getText())));
                } catch (NumberFormatException e) {
                }
                break;
        }
    }
}

