package v2ch07.dnd;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates the basic Swing support for drag and drop.
 *
 * @author Cay Horstmann
 * @version 1.10 2007-09-20
 */
public class SwingDnDTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new SwingDnDFrame();
                frame.setTitle("SwingDnDTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}