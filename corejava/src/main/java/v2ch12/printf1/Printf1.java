package v2ch12.printf1;

/**
 * @author Cay Horstmann
 * @version 1.10 1997-07-01
 */
class Printf1 {
    static {
        System.loadLibrary("Printf1");
    }

    public static native int print(int width, int precision, double x);
}
