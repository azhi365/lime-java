package org.walnuts.study.corejava.v2ch06.treeRender;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates cell rendering and listening to tree selection events.
 *
 * @author Cay Horstmann
 * @version 1.03 2007-08-01
 */
public class ClassTree {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new ClassTreeFrame();
                frame.setTitle("ClassTree");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

