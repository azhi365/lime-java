package org.walnuts.study.corejava.v2ch07.imageProcessing;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates various image processing operations.
 *
 * @author Cay Horstmann
 * @version 1.03 2007-08-16
 */
public class ImageProcessingTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new ImageProcessingFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}