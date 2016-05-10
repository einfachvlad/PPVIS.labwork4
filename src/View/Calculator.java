package View;

import View.CalculatorParts.*;
import View.Window;

import javax.swing.*;

/**
 * Created by einfach_vlad on 23.04.16.
 */
public class Calculator {
    private Box calculatorPanel;
    Screen calculatorScreen;
    ButtonsPanel buttonsPanel;

    public Calculator(Window window,Tree tree) {

        calculatorPanel = Box.createVerticalBox();
        calculatorScreen = new Screen();
        buttonsPanel=new ButtonsPanel(calculatorScreen,window,tree);

        calculatorPanel.add(calculatorScreen.getScreen());
        calculatorPanel.add(Box.createVerticalStrut(6));
        calculatorPanel.add(buttonsPanel.getPanel());

    }

    public Box getPanel() {
        return calculatorPanel;
    }
}
