import View.Window;
import com.sun.java.swing.plaf.gtk.GTKLookAndFeel;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new GTKLookAndFeel());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Window window = new Window();
    }
}

