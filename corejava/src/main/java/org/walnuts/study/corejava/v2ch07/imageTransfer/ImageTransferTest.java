package org.walnuts.study.corejava.v2ch07.imageTransfer;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates the transfer of images between a Java application and the system
 * clipboard.
 *
 * @author Cay Horstmann
 * @version 1.22 2007-08-16
 */
public class ImageTransferTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new ImageTransferFrame();
                frame.setTitle("ImageTransferTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

