package v1ch09.slider;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.14 2012-01-26
 */
public class SliderTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                SliderFrame frame = new SliderFrame();
                frame.setTitle("SliderTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}