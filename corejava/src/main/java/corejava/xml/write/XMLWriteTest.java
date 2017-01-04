package corejava.xml.write;

import javax.swing.*;
import java.awt.*;

/**
 * This program shows how to write an XML file. It saves a file describing a modern drawing in SVG
 * format.
 *
 * @author Cay Horstmann
 * @version 1.11 2012-01-26
 */
public class XMLWriteTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new XMLWriteFrame();
            frame.setTitle("XMLWriteTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}