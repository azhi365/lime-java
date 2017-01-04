package corejava.swing.fileChooser;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.24 2012-05-05
 */
public class FileChooserTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new ImageViewerFrame();
                frame.setTitle("FileChooserTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

