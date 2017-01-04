package corejava.concurrency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Shows an animated bouncing ball.
 *
 * @author Cay Horstmann
 * @version 1.33 2007-05-17
 */
public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    /**
     * The frame with ball component and buttons.
     */
    static class BounceFrame extends JFrame {
        public static final int STEPS = 1000;
        public static final int DELAY = 3;
        private BallComponent comp;

        /**
         * Constructs the frame with the component for showing the bouncing ball and Start and Close
         * buttons
         */
        public BounceFrame() {
            setTitle("Bounce");

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
         * Adds a bouncing ball to the panel and makes it e1_3_bounce 1,000 times.
         */
        public void addBall() {
            try {
                Ball ball = new Ball();
                comp.add(ball);

                // sync block
                for (int i = 1; i <= STEPS; i++) {
                    ball.move(comp.getBounds());
                    comp.paint(comp.getGraphics());
                    Thread.sleep(DELAY);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    /**
     * The component that draws the balls.
     *
     * @author Cay Horstmann
     * @version 1.34 2012-01-26
     */
    public static class BallComponent extends JPanel {
        private static final int DEFAULT_WIDTH = 450;
        private static final int DEFAULT_HEIGHT = 350;

        private java.util.List<Ball> balls = new ArrayList<>();

        /**
         * Add a ball to the component.
         *
         * @param b the ball to add
         */
        public void add(Ball b) {
            balls.add(b);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g); // erase background
            Graphics2D g2 = (Graphics2D) g;
            for (Ball b : balls) {
                g2.fill(b.getShape());
            }
        }

        public Dimension getPreferredSize() {
            return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
    }


    /**
     * A ball that moves and bounces off the edges of a rectangle
     *
     * @author Cay Horstmann
     * @version 1.33 2007-05-17
     */
    public static class Ball {
        private static final int XSIZE = 15;
        private static final int YSIZE = 15;
        private double x = 0;
        private double y = 0;
        private double dx = 1;
        private double dy = 1;

        /**
         * Moves the ball to the next position, reversing direction if it hits one of the edges
         */
        public void move(Rectangle2D bounds) {
            x += dx;
            y += dy;
            if (x < bounds.getMinX()) {
                x = bounds.getMinX();
                dx = -dx;
            }
            if (x + XSIZE >= bounds.getMaxX()) {
                x = bounds.getMaxX() - XSIZE;
                dx = -dx;
            }
            if (y < bounds.getMinY()) {
                y = bounds.getMinY();
                dy = -dy;
            }
            if (y + YSIZE >= bounds.getMaxY()) {
                y = bounds.getMaxY() - YSIZE;
                dy = -dy;
            }
        }

        /**
         * Gets the shape of the ball at its current position.
         */
        public Ellipse2D getShape() {
            return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
        }
    }

}


