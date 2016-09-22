package v2ch12.printf2;

/**
 * @author Cay Horstmann
 * @version 1.10 1997-07-01
 */
class Printf2 {
    static {
        System.loadLibrary("Printf2");
    }

    public static native String sprint(String format, double x);
}
