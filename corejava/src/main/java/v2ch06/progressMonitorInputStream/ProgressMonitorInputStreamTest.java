package v2ch06.progressMonitorInputStream;

import javax.swing.*;
import java.awt.*;

/**
 * A program to test a progress monitor input stream.
 *
 * @author Cay Horstmann
 * @version 1.05 2012-01-26
 */
public class ProgressMonitorInputStreamTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new TextFrame();
                frame.setTitle("ProgressMonitorInputStreamTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}