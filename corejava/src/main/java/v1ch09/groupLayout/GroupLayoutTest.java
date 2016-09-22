package v1ch09.groupLayout;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.0 2012-05-05
 */
public class GroupLayoutTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new FontFrame();
                frame.setTitle("GroupLayoutTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}