/**
 * 
 * @author YZhi
 * @date 2012-5-17
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.creation.builder.superman;

import org.junit.Test;

/**
 * 该例子与工厂方法模式的例子对比
 * @author YZhi
 * @since 1.0
 */
public class SuperManClient {
	@Test
	public void testSuperMan(){
		SuperMan adultSuperMan = Director.getAdultSuperMan();
		System.out.println(adultSuperMan.getSpecialTalent());
	}
}
