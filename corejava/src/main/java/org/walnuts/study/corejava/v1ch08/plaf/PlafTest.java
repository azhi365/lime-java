package org.walnuts.study.corejava.v1ch08.plaf;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.32 2007-06-12
 */
public class PlafTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new PlafFrame();
                frame.setTitle("PlafTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}