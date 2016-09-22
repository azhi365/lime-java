package v2ch12.printf4;

import java.io.PrintWriter;

/**
 * @author Cay Horstmann
 * @version 1.10 1997-07-01
 */
class Printf4 {
    static {
        System.loadLibrary("Printf4");
    }

    public static native void fprint(PrintWriter ps, String format, double x);
}
