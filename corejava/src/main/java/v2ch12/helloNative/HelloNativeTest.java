package v2ch12.helloNative;

/**
 * @author Cay Horstmann
 * @version 1.11 2007-10-26
 */
class HelloNativeTest {
    static {
        System.loadLibrary("HelloNative");
    }

    public static void main(String[] args) {
        HelloNative.greeting();
    }
}
