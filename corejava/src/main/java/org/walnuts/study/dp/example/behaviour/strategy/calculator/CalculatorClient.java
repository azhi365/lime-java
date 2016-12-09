/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午04:40:06
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.strategy.calculator;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 * @author yzhi
 * @date 2012-1-20
 * @version 
 */
public class CalculatorClient {
	@Test
	public void testCalculator(){
		Assert.assertEquals(8, Calculator.ADD.exec(5, 3));
	}
}
