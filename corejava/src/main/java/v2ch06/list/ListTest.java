package v2ch06.list;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates a simple fixed list of strings.
 *
 * @author Cay Horstmann
 * @version 1.24 2012-06-07
 */
public class ListTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new ListFrame();
                frame.setTitle("ListTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}