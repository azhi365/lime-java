package org.walnuts.study.corejava.v2ch07.desktopApp;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates the desktop app API.
 *
 * @author Cay Horstmann
 * @version 1.00 2007-09-22
 */
public class DesktopAppTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new DesktopAppFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}