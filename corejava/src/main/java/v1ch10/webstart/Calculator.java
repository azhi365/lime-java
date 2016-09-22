package v1ch10.webstart;

import javax.swing.*;
import java.awt.*;

/**
 * A calculator with a calculation history that can be deployed as a Java Web Start application.
 *
 * @author Cay Horstmann
 * @version 1.03 2012-05-14
 */
public class Calculator {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                CalculatorFrame frame = new CalculatorFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}