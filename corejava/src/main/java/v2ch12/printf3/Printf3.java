package v2ch12.printf3;

import java.io.PrintWriter;

/**
 * @author Cay Horstmann
 * @version 1.10 1997-07-01
 */
class Printf3 {
    static {
        System.loadLibrary("Printf3");
    }

    public static native void fprint(PrintWriter out, String format, double x);
}
