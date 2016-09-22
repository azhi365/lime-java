/**
 * 
 * @author YZhi
 * @date 2012-5-17
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.creation.builder.car;

import org.junit.Test;

/**
 * 与抽象工厂模式对比
 * @author YZhi
 * @since 1.0
 */
public class CarClient {
	@Test
	public void testCar(){
		Director director = new Director();
		ICar benzSuv =director.createBenzSuv();
		System.out.println(benzSuv);
		ICar bmwvan = director.createBMWVan();
		System.out.println(bmwvan);
		ICar complexCar =director.createComplexCar();
		System.out.println(complexCar);
	}
}
