package org.walnuts.study.corejava.v2ch06.textChange;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.40 2007-08-05
 */
public class ChangeTrackingTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new ColorFrame();
                frame.setTitle("ChangeTrackingTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}