package corejava.deploying.systemInfo;

import java.io.IOException;
import java.util.Properties;

/**
 * This program prints out all system properties.
 *
 * @author Cay Horstmann
 * @version 1.10 2002-07-06
 */
public class SystemInfo {
    public static void main(String args[]) {
        try {
            Properties sysprops = System.getProperties();
            sysprops.store(System.out, "System Properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
