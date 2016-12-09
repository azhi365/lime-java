/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午03:01:33
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.factorymethod.human;

/**
 * 简单工厂模式
 * @author YZhi
 * @since 1.0
 */
public class HumanFactorySimple {
	@SuppressWarnings("unchecked")
	public static <T extends Human> T createHuman(Class<T> c){
		Human human = null;
		try {
			human = (Human)Class.forName(c.getName()).newInstance();
		} catch (Exception e) {
			System.out.println("error");
		}
		return (T)human;
	}
}
