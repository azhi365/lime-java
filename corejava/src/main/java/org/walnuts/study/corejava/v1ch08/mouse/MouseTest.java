package org.walnuts.study.corejava.v1ch08.mouse;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.33 2012-01-26
 */
public class MouseTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new MouseFrame();
                frame.setTitle("MouseTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}