package org.walnuts.study.corejava.v2ch06.longList;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates a list that dynamically computes list entries.
 *
 * @author Cay Horstmann
 * @version 1.23 2007-08-01
 */
public class LongListTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new LongListFrame();
                frame.setTitle("LongListTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}


