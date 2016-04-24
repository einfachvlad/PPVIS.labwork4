package View.CalculatorParts;

import Controller.CommandAction;
import Controller.InsertAction;

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
    private JPanel buttonsPanel;
    private Screen screen;

    public ButtonsPanel(Screen screen) {
        buttonsPanel = new JPanel();
        this.screen = screen;
        buildPanel();
    }

    private void buildPanel() {
        buttonsPanel.setLayout(new GridLayout(5, 5, 3, 3));

        addButton("DEL",ButtonsPanel.COMMAND );
        addButton("(",ButtonsPanel.INSERT);
        addButton(")",ButtonsPanel.INSERT);
        addButton("C",ButtonsPanel.COMMAND);
        addButton("sqrt",ButtonsPanel.COMMAND);

        addButton("7",ButtonsPanel.INSERT);
        addButton("8",ButtonsPanel.INSERT);
        addButton("9",ButtonsPanel.INSERT);
        addButton("*",ButtonsPanel.INSERT);
        addButton("/",ButtonsPanel.INSERT);

        addButton("4",ButtonsPanel.INSERT);
        addButton("5",ButtonsPanel.INSERT);
        addButton("6",ButtonsPanel.INSERT);
        addButton("+",ButtonsPanel.COMMAND);
        addButton("-",ButtonsPanel.COMMAND);

        addButton("1",ButtonsPanel.INSERT);
        addButton("2",ButtonsPanel.INSERT);
        addButton("3",ButtonsPanel.INSERT);
        addButton("%",ButtonsPanel.COMMAND);
        addButton("1/x",ButtonsPanel.COMMAND);

        addButton("0",ButtonsPanel.INSERT);
        addButton(".",ButtonsPanel.INSERT);
        addButton("=",ButtonsPanel.COMMAND);
    }


    private void addButton(String label, String listener) {
        NumberButton button = new NumberButton(label);
        switch (listener) {
            case ButtonsPanel.INSERT:
                button.getButton().addActionListener(new InsertAction(button.getButton(), screen));
                break;
            case ButtonsPanel.COMMAND:
                button.getButton().addActionListener(new CommandAction(button.getButton(), screen));
                break;
        }
        buttonsPanel.add(button.getButton());
    }

    public JPanel getPanel() {
        return buttonsPanel;
    }

}
