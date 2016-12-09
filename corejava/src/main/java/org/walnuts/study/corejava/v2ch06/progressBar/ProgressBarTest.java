package org.walnuts.study.corejava.v2ch06.progressBar;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates the use of a progress bar to monitor the progress of a thread.
 *
 * @author Cay Horstmann
 * @version 1.04 2007-08-01
 */
public class ProgressBarTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new ProgressBarFrame();
                frame.setTitle("ProgressBarTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
