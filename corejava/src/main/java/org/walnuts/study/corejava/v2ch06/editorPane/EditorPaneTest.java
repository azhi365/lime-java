package org.walnuts.study.corejava.v2ch06.editorPane;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates how to display HTML documents in an editor pane.
 *
 * @author Cay Horstmann
 * @version 1.04 2012-01-26
 */
public class EditorPaneTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new EditorPaneFrame();
                frame.setTitle("EditorPaneTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
