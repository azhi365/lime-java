package v2ch06.spinner;

import javax.swing.*;
import java.awt.*;

/**
 * A program to test spinners.
 *
 * @author Cay Horstmann
 * @version 1.02 2007-08-01
 */
public class SpinnerTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new SpinnerFrame();
                frame.setTitle("SpinnerTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

