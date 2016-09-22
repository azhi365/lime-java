/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午03:34:49
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.creation.singleton.emperor;

/**
 * 皇帝类
 * 
 * @author YZhi
 * @since 1.0
 */
public class Emperor {
	private static final Emperor emperor = new Emperor();
	public static Emperor getInstance(){
		return emperor;
	}
	public void say(){
		System.out.println("I am emperor o");
	}
}
