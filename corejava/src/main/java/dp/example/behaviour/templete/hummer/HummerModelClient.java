/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午04:36:52
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.templete.hummer;

import org.junit.Test;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class HummerModelClient {
	@Test
	public void testHummerModel() {
		HummerModel h1 = new HummerAModel();
		h1.run();
		System.out.println("-------------");
	}
	
	@Test
	public void testHummerAModel(){
		HummerAModel h1 = new HummerAModel();
		h1.setAlarm(false);
		h1.run();
		h1.setAlarm(true);
		h1.run();
		System.out.println("-------------");
	}
	@Test
	public void testHummerBModel(){
		HummerBModel h2 = new HummerBModel();
		h2.run();
		System.out.println("-------------");
	}
}
