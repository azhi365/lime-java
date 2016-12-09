package org.walnuts.study.corejava.v2ch06.tableCellRender;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates cell rendering and editing in a table.
 *
 * @author Cay Horstmann
 * @version 1.03 2012-06-08
 */
public class TableCellRenderTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                JFrame frame = new TableCellRenderFrame();
                frame.setTitle("TableCellRenderTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}