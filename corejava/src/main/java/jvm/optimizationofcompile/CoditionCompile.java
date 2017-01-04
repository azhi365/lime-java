package jvm.optimizationofcompile;

/**
 * Created by YZhi on 1/4/2017.
 */
public class CoditionCompile {
    public static void main(String[] args) {
        if (true) {
            System.out.println("block 1");
        } else {
            System.out.println("block 2");
        }

        //Class文件的反编译结果
        // System.out.println（"block 1"）；

        // 编译器将会提示“Unreachable code”
/*        while (false) {
            System.out.println("");
        }*/

    }
}
