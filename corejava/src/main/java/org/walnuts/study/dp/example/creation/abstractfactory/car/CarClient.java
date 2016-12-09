/**
 * 
 * @author YZhi
 * @date 2012-5-17
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.abstractfactory.car;

import org.junit.Test;

/**
 * 与建造者模式对比
 * @author YZhi
 * @since 1.0
 */
public class CarClient {
	@Test
	public void testCar(){
		CarFactory carFactory = new BenzFactory();
		ICar benzSuv =  carFactory.createSuv();
		System.out.println(benzSuv.getBand());
		System.out.println(benzSuv.getModel());
		
	}
}
