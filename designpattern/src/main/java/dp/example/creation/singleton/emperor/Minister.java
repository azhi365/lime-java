/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午03:36:53
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.creation.singleton.emperor;

import org.junit.Test;

/**
 * 大臣类
 * @author YZhi
 * @since 1.0
 */
public class Minister {
	@Test
	public void testEmperor(){
		for (int i = 0; i < 3; i++) {
			Emperor emperor = Emperor.getInstance();
			emperor.say();
		}
	}
	
	@Test
	public void testEmperorNulti(){
		for (int i = 0; i < 5; i++) {
			EmperorMulti emperorMulti = EmperorMulti.getInstance();
			emperorMulti.say();
		}
	}
	
}
