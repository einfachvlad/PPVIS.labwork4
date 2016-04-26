package View.CalculatorParts;

import Controller.CommandAction;
import Controller.InsertAction;
import Controller.RadioAction;
import View.*;
import View.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by einfach_vlad on 23.04.16.
 */
public class ButtonsPanel {
    public final static String COMMAND = "command";
    public final static String INSERT = "insert";
    public JRadioButton trig;
    private Box buttonsPanel;
    private Screen screen;
    private Window window;

    public ButtonsPanel(Screen screen, Window window) {
        this.window = window;

        buttonsPanel = Box.createVerticalBox();
        this.screen = screen;


        trig = new JRadioButton("Trig");
        trig.addActionListener(new RadioAction(this, window, screen));
        buttonsPanel.add(extraPanel());
        buttonsPanel.add(simplePanel());

    }

    private Box extraPanel() {
        Box extrapanel = Box.createHorizontalBox();
        extrapanel.add(trig);
        extrapanel.add(Box.createHorizontalGlue());
        return extrapanel;
    }

    private void addButton(JPanel panel, String label, String listener) {
        NumberButton button = new NumberButton(label);
        switch (listener) {
            case ButtonsPanel.INSERT:
                button.getButton().addActionListener(new InsertAction(button.getButton(), screen));
                break;
            case ButtonsPanel.COMMAND:
                button.getButton().addActionListener(new CommandAction(button.getButton(), screen));
                break;
        }
        panel.add(button.getButton());
    }

    public Box getPanel() {
        return buttonsPanel;
    }

    public JPanel simplePanel() {
        JPanel simplePanel = new JPanel();
        simplePanel.setLayout(new GridLayout(5, 5, 3, 3));

        addButton(simplePanel, "DEL", ButtonsPanel.COMMAND);
        addButton(simplePanel, "C", ButtonsPanel.COMMAND);
        addButton(simplePanel, "(", ButtonsPanel.INSERT);
        addButton(simplePanel, ")", ButtonsPanel.INSERT);
        addButton(simplePanel, "sqrt", ButtonsPanel.COMMAND);

        addButton(simplePanel, "7", ButtonsPanel.INSERT);
        addButton(simplePanel, "8", ButtonsPanel.INSERT);
        addButton(simplePanel, "9", ButtonsPanel.INSERT);
        addButton(simplePanel, "*", ButtonsPanel.INSERT);
        addButton(simplePanel, "/", ButtonsPanel.INSERT);

        addButton(simplePanel, "4", ButtonsPanel.INSERT);
        addButton(simplePanel, "5", ButtonsPanel.INSERT);
        addButton(simplePanel, "6", ButtonsPanel.INSERT);
        addButton(simplePanel, "+", ButtonsPanel.COMMAND);
        addButton(simplePanel, "-", ButtonsPanel.COMMAND);

        addButton(simplePanel, "1", ButtonsPanel.INSERT);
        addButton(simplePanel, "2", ButtonsPanel.INSERT);
        addButton(simplePanel, "3", ButtonsPanel.INSERT);
        addButton(simplePanel, "%", ButtonsPanel.COMMAND);
        addButton(simplePanel, "1/x", ButtonsPanel.COMMAND);

        addButton(simplePanel, "0", ButtonsPanel.INSERT);
        addButton(simplePanel, ".", ButtonsPanel.INSERT);
        addButton(simplePanel, "=", ButtonsPanel.COMMAND);

        Dimension simpleDimension = new Dimension(312, 312);
        simplePanel.setSize(simpleDimension);
        simplePanel.setMinimumSize(simpleDimension);

        return simplePanel;
    }

    public JPanel trigPanel() {
        JPanel trigPanel = new JPanel();
        trigPanel.setLayout(new GridLayout(5, 2, 3, 3));

        addButton(trigPanel, "sin", ButtonsPanel.COMMAND);
        addButton(trigPanel, "cos", ButtonsPanel.COMMAND);
        addButton(trigPanel, "tan", ButtonsPanel.COMMAND);
        addButton(trigPanel, "ctan", ButtonsPanel.COMMAND);

        addButton(trigPanel, "sinh", ButtonsPanel.COMMAND);
        addButton(trigPanel, "cosh", ButtonsPanel.COMMAND);
        addButton(trigPanel, "tanh", ButtonsPanel.COMMAND);
        addButton(trigPanel, "ctanh", ButtonsPanel.COMMAND);

        Dimension trigDemension = new Dimension(123, 259);
        trigPanel.setSize(trigDemension);
        trigPanel.setMinimumSize(trigDemension);

        return trigPanel;
    }

}
