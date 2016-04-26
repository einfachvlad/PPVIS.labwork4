package Controller;

import View.*;
import View.CalculatorParts.ButtonsPanel;
import View.CalculatorParts.ButtonsPanel;
import View.CalculatorParts.Screen;
import View.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by einfach_vlad on 25.04.16.
 */
public class RadioAction implements ActionListener {

    private ButtonsPanel panel;
    private Window window;
    private Screen screen;

    public RadioAction(ButtonsPanel panel, Window window, Screen screen) {
        this.panel = panel;
        this.window = window;
        this.screen = screen;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (panel.trig.isSelected()) {
            panel.getPanel().remove(panel.getPanel().getComponentCount() - 1);

            Box customPanel = Box.createHorizontalBox();
            customPanel.add(panel.simplePanel());
            customPanel.add(panel.trigPanel());

            panel.getPanel().add(customPanel);

            Dimension panelDimension = new Dimension(panel.simplePanel().getWidth() + panel.trigPanel().getWidth(), panel.getPanel().getHeight());
            panel.getPanel().setMinimumSize(panelDimension);
            panel.getPanel().setSize(panelDimension);

            window.getFrame().setSize(panel.getPanel().getWidth(), window.getFrame().getHeight());

            panel.getPanel().validate();

        } else {
            panel.getPanel().remove(panel.getPanel().getComponentCount() - 1);
            panel.getPanel().add(panel.simplePanel());

            Dimension panelDimension = new Dimension(panel.simplePanel().getWidth(), panel.getPanel().getHeight());

            panel.getPanel().setMinimumSize(panelDimension);
            panel.getPanel().setSize(panelDimension);

            window.getFrame().setSize(panel.getPanel().getWidth(), window.getFrame().getHeight());

            panel.getPanel().validate();
        }


    }
}
