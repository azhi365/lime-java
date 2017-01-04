/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午05:27:08
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.creation.builder.carmodel;

import org.junit.Test;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class CarModelClient {
	@Test
	public void testCarBuilder(){
		Director director = new Director();
		for (int i = 0; i < 1000; i++) {
			director.getABenzModel().run();
		}
		
		for (int i = 0; i < 1000; i++) {
			director.getBBenzModel().run();
		}
		
		for (int i = 0; i < 1000; i++) {
			director.getCBMWModel().run();
		}
		for (int i = 0; i < 1000; i++) {
			director.getDBMWModel().run();
		}
	}
}
