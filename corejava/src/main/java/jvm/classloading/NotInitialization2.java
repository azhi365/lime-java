package jvm.classloading;

/**
 * 非主动使用类字段演示
 **/
public class NotInitialization2 {

	public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
	}
}
