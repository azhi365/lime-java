package com.innstack.lime.test.image;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Collection;

/**
 * Created by YZhi on 2016/10/10.
 */
public class ImageTestCase {
    @Test
    public void testZoom() throws  Exception {
        Collection<File> files = FileUtils.listFiles(new File("D:\\Users\\YZhi\\Desktop\\photo"), null, false);
        String dir = "D:\\Users\\YZhi\\Desktop\\dest\\";
        for (File file : files) {
            BufferedImage srcBufferedImage = ImageIO.read(file);
            int width = srcBufferedImage.getWidth();
            int height = srcBufferedImage.getHeight();
            int destWidth = 0;
            int destHeight = 0;
            if(height > width){
                destHeight = 960;
                destWidth = (int) ((float)destHeight / height * width);
            }else{
                destWidth = 640;
                destHeight = (int)((float)destWidth /width * height);
            }

            ImageUtils.zoom(file, new File(dir + file.getName()), destWidth, destHeight);
            //ImageUtils.zoom(file, new File(dir + file.getName().replaceAll(".jpg","") + "_200x200.jpg"), 200, 200);
        }
    }
}
