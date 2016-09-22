package v2ch06.treeEdit;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates tree editing.
 *
 * @author Cay Horstmann
 * @version 1.03 2007-08-01
 */
public class TreeEditTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new TreeEditFrame();
                frame.setTitle("TreeEditTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}