package corejava.swing.colorChooser;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.03 2007-06-12
 */
public class ColorChooserTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new ColorChooserFrame();
                frame.setTitle("ColorChooserTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}



