package org.walnuts.study.corejava.v2ch06.treeModel;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates how to use a custom tree model. It displays the fields of an object.
 *
 * @author Cay Horstmann
 * @version 1.04 2012-01-26
 */
public class ObjectInspectorTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new ObjectInspectorFrame();
                frame.setTitle("ObjectInspectorTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}



