package v1ch14.e4_bounceThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Shows animated bouncing balls.
 *
 * @author Cay Horstmann
 * @version 1.33 2007-05-17
 */
public class BounceThread {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setTitle("BounceThread");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * A runnable that animates a bouncing ball.
 */
class BallRunnable implements Runnable {
    public static final int STEPS = 1000;
    public static final int DELAY = 5;
    private Ball ball;
    private Component component;

    /**
     * Constructs the runnable.
     *
     * @param aBall      the ball to e1_3_bounce
     * @param aComponent the component in which the ball bounces
     */
    public BallRunnable(Ball aBall, Component aComponent) {
        ball = aBall;
        component = aComponent;
    }

    public void run() {
        try {
            for (int i = 1; i <= STEPS; i++) {
                ball.move(component.getBounds());
                component.repaint();
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {
        }
    }

}

/**
 * The frame with panel and buttons.
 */
class BounceFrame extends JFrame {
    private BallComponent comp;

    /**
     * Constructs the frame with the component for showing the bouncing ball and Start and Close
     * buttons
     */
    public BounceFrame() {
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", event -> addBall());

        addButton(buttonPanel, "Close", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    /**
     * Adds a button to a container.
     *
     * @param c        the container
     * @param title    the button title
     * @param listener the action listener for the button
     */
    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    /**
     * Adds a bouncing ball to the canvas and starts a thread to make it e1_3_bounce
     */
    public void addBall() {
        Ball b = new Ball();
        comp.add(b);
        //new thread unblock
        Runnable r = new BallRunnable(b, comp);
        Thread t = new Thread(r);
        t.start();
    }
}
