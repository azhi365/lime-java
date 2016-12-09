/**
 * 
 * @author YZhi
 * @date 2012-5-17
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.factorymethod.superman;

import org.junit.Test;

/**
 * 该例子与建造者模式的例子对比
 * @author YZhi
 * @since 1.0
 */
public class SuperManClient {
	@Test
	public void testSuperMan(){
		ISuperMan superMan = SuperManFactory.createSuperMan("adult");
		superMan.specialTalent();
	}
}
