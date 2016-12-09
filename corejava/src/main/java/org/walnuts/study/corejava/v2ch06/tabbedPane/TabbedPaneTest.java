package org.walnuts.study.corejava.v2ch06.tabbedPane;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates the tabbed pane component organizer.
 *
 * @author Cay Horstmann
 * @version 1.03 2007-08-01
 */
public class TabbedPaneTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                JFrame frame = new TabbedPaneFrame();
                frame.setTitle("TabbedPaneTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

