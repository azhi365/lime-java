package v2ch07.transferText;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates the transfer of text between a Java application and the system
 * clipboard.
 *
 * @author Cay Horstmann
 * @version 1.13 2007-08-16
 */
public class TextTransferTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new TextTransferFrame();
                frame.setTitle("TextTransferTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}