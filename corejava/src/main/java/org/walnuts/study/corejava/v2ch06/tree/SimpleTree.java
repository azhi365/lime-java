package org.walnuts.study.corejava.v2ch06.tree;

import javax.swing.*;
import java.awt.*;

/**
 * This program shows a simple tree.
 *
 * @author Cay Horstmann
 * @version 1.02 2007-08-01
 */
public class SimpleTree {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new SimpleTreeFrame();
                frame.setTitle("SimpleTree");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
