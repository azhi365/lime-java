package v2ch06.progressMonitor;

import javax.swing.*;
import java.awt.*;

/**
 * A program to test a progress monitor dialog.
 *
 * @author Cay Horstmann
 * @version 1.04 2007-08-01
 */
public class ProgressMonitorTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new ProgressMonitorFrame();
                frame.setTitle("ProgressMonitorTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}