package View;

import View.CalculatorParts.ButtonsPanel;
import View.CalculatorParts.Screen;

import javax.swing.*;

/**
 * Created by einfach_vlad on 23.04.16.
 */
public class Calculator {
    private Box calculatorPanel;
    Screen calculatorScreen;
    ButtonsPanel buttonsPanel;

    public Calculator() {
        calculatorPanel = Box.createVerticalBox();
        calculatorScreen = new Screen();
        buttonsPanel=new ButtonsPanel(calculatorScreen);

        calculatorPanel.add(calculatorScreen.getScreen());
        calculatorPanel.add(Box.createVerticalStrut(6));
        calculatorPanel.add(buttonsPanel.getPanel());

    }

    public Box getPanel() {
        return calculatorPanel;
    }
}
