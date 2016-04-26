package View;

import javax.swing.*;

/**
 * Created by einfach_vlad on 23.04.16.
 */
public class Window {
    JFrame mainwidnow;

    public Window() {
        mainwidnow = new JFrame("Лабораторная работа №4");
        mainwidnow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Calculator calculator=new Calculator(this);
        mainwidnow.setContentPane(calculator.getPanel());

        mainwidnow.pack();
        mainwidnow.setVisible(true);
    }

    public JFrame getFrame(){
        return mainwidnow;
    }

}
