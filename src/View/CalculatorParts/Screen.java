package View.CalculatorParts;

import javax.swing.*;
import java.awt.*;

/**
 * Created by einfach_vlad on 23.04.16.
 */
public class Screen {
    JScrollPane scrollPane;
    JTextField screen;

    public Screen(){
        screen=new JTextField();
        screen.setEnabled(false);
        scrollPane=new JScrollPane(screen);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        screen.setPreferredSize(new Dimension(150,50));
        screen.setSize(150,30);
    }

    public JTextField getScreen(){
        return screen;
    }

    public JScrollPane getScrollPane(){
        return scrollPane;
    }
}
