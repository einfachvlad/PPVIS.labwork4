package Controller;

import View.CalculatorParts.Screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;

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
        if (button.getText() == "=")
            screen.getScreen().setText(String.valueOf(reversePolishNotation.eval(screen.getScreen().getText())));
        else if (button.getText() == "sqrt")
            screen.getScreen().setText(String.valueOf(Math.sqrt(Integer.parseInt(screen.getScreen().getText()))));
        else
            screen.getScreen().setText(screen.getScreen().getText() + input);
        if (button.getText() == "C")
            screen.getScreen().setText("");
        if (button.getText() == "DEL")
            screen.getScreen().setText(screen.getScreen().getText().substring(0, screen.getScreen().getText().length() - 4));

    }
}
