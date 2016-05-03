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

        TreePanel treePanel=new TreePanel();
        Calculator calculator=new Calculator(this,treePanel);

        Box boxPanel=Box.createHorizontalBox();
        boxPanel.add(treePanel.getPanel());
        boxPanel.add(Box.createHorizontalStrut(12));
        boxPanel.add(calculator.getPanel());

        mainwidnow.setContentPane(boxPanel);

        mainwidnow.pack();
        System.out.println(mainwidnow.getWidth());
        treePanel.setHeight(mainwidnow.getHeight());


        mainwidnow.setVisible(true);
    }

    public JFrame getFrame(){
        return mainwidnow;
    }

}
