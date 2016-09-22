package v2ch06.internalFrame;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates the use of internal frames.
 *
 * @author Cay Horstmann
 * @version 1.11 2007-08-01
 */
public class InternalFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new DesktopFrame();
                frame.setTitle("InternalFrameTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}