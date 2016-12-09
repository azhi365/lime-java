package org.walnuts.study.corejava.v2ch08.imageViewer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A bean for viewing an image.
 *
 * @author Cay Horstmann
 * @version 1.22 2012-06-10
 */
public class ImageViewerBean extends JLabel {
    private static final int XPREFSIZE = 200;
    private static final int YPREFSIZE = 200;
    private Path path = null;

    public ImageViewerBean() {
        setBorder(BorderFactory.createEtchedBorder());
    }

    /**
     * Gets the fileName property.
     *
     * @return the image file name
     */
    public String getFileName() {
        if (path == null)
            return "";
        else
            return path.toString();
    }

    /**
     * Sets the fileName property.
     *
     * @param fileName the image file name
     */
    public void setFileName(String fileName) {
        path = Paths.get(fileName);
        try (InputStream in = Files.newInputStream(path)) {
            setIcon(new ImageIcon(ImageIO.read(in)));
        } catch (IOException e) {
            path = null;
            setIcon(null);
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(XPREFSIZE, YPREFSIZE);
    }
}
