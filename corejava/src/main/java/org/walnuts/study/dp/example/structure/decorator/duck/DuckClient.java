/**
 * 
 * @author YZhi
 * @date 2012-5-22
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.decorator.duck;

import org.junit.Test;

import org.walnuts.study.dp.example.structure.adapter.duck.Duck;
import org.walnuts.study.dp.example.structure.adapter.duck.Duckling;

/**
 * <pre>
 * 装饰模式VS适配器模式
 * 装饰模式包装的是自己的兄弟类，隶属于同一个家族(相同接口或父类)
 * 适配器模式修饰非血缘关系类，把一个非本家族的对象伪装成本家族的对象
 * </pre>
 * @author YZhi
 * @since 1.0
 */
public class DuckClient {
	
	/**
	 *装饰模式
	 */
	@Test
	public void testDuckDecorator(){
		Swan duckling = new UglyDuckling();
		duckling.desAppearance();
		duckling.cry();
		duckling.fly();
		
		duckling = new BeautfulAppearance(duckling);
		duckling = new StrongBehavior(duckling);
		duckling.desAppearance();
		duckling.fly();
		
	}
	
	/**
	 *适配器模式
	 */
	@Test
	public void testDuckAdapter(){
		Duck duck = new Duckling();
		duck.cry();
		duck.desAppearance();
		duck.desBehavior();
		
		Duck uglyDuckling = new org.walnuts.study.dp.example.structure.adapter.duck.UglyDuckling();
		uglyDuckling.cry();
		uglyDuckling.desAppearance();
		uglyDuckling.desBehavior();
	}
}
