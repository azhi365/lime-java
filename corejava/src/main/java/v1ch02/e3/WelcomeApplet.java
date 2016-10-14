package v1ch02.e3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This applet displays a greeting from the authors.
 *
 * @author Cay Horstmann
 * @version 1.22 2007-04-08
 */
public class WelcomeApplet extends JApplet {
    public void init() {
        EventQueue.invokeLater(() -> {
            setLayout(new BorderLayout());

            JLabel label = new JLabel(getParameter("greeting"), SwingConstants.CENTER);
            label.setFont(new Font("Serif", Font.BOLD, 18));
            add(label, BorderLayout.CENTER);

            JPanel panel = new JPanel();


            JButton cayButton = new JButton("Cay Horstmann");
            cayButton.addActionListener(makeAction("http://www.horstmann.com"));
            panel.add(cayButton);

            JButton garyButton = new JButton("Gary Cornell");
            garyButton.addActionListener(makeAction("mailto:gary_cornell@apress.com"));
            panel.add(garyButton);

            add(panel, BorderLayout.SOUTH);
        });

    }

    private ActionListener makeAction(final String urlString) {

        return event -> {
            try {
                getAppletContext().showDocument(new URL(urlString));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        };
    }
}
