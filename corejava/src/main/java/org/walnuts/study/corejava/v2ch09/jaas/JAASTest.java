package org.walnuts.study.corejava.v2ch09.jaas;

import javax.swing.*;
import java.awt.*;

/**
 * This program authenticates a user via a custom login and then looks up a system property with the
 * user's privileges.
 *
 * @author Cay Horstmann
 * @version 1.01 2012-06-10
 */
public class JAASTest {
    public static void main(final String[] args) {
        System.setSecurityManager(new SecurityManager());
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JAASFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setTitle("JAASTest");
                frame.setVisible(true);
            }
        });
    }
}
