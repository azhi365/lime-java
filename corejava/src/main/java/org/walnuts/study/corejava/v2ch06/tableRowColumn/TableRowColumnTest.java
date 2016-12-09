package org.walnuts.study.corejava.v2ch06.tableRowColumn;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates how to work with rows and columns in a table.
 *
 * @author Cay Horstmann
 * @version 1.21 2012-01-26
 */
public class TableRowColumnTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new PlanetTableFrame();
                frame.setTitle("TableRowColumnTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}