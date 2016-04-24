package View.CalculatorParts;

import javax.swing.*;
import java.awt.*;

/**
 * Created by einfach_vlad on 23.04.16.
 */
public class NumberButton {
    JButton numberButton;

    public NumberButton(String number) {
        numberButton = new JButton(number);
        numberButton.setSize(50,50);
        numberButton.setPreferredSize(new Dimension(60,60));
    }
    public JButton getButton(){
        return numberButton;
    }
}
