package org.walnuts.study.corejava.v2ch06.layer;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates how a layer can decorate a Swing component.
 *
 * @author Cay Horstmann
 * @version 1.0 2012-06-08
 */
public class LayerTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new ColorFrame();
                frame.setTitle("LayerTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}