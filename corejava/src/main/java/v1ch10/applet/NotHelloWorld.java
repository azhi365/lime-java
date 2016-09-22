package v1ch10.applet;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.23 2012-05-14
 */
public class NotHelloWorld extends JApplet {
    public void init() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JLabel label = new JLabel("Not a Hello, World applet", SwingConstants.CENTER);
                add(label);
            }
        });
    }
}