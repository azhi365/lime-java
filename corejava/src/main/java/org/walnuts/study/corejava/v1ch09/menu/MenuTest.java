package org.walnuts.study.corejava.v1ch09.menu;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.23 2007-05-30
 */
public class MenuTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new MenuFrame();
                frame.setTitle("MenuTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}