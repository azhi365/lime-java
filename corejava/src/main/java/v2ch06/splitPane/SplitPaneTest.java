package v2ch06.splitPane;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates the split pane component organizer.
 *
 * @author Cay Horstmann
 * @version 1.03 2007-08-01
 */
public class SplitPaneTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new SplitPaneFrame();
                frame.setTitle("SplitPaneTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}