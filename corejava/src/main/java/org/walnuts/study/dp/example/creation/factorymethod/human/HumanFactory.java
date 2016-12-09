/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午02:53:59
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.factorymethod.human;

/**
 * 人类创建工厂
 * @author YZhi
 * @since 1.0
 */
public class HumanFactory extends AbstractHumanFactory {

	/* (non-Javadoc)
	 * @see creation.factorymethod.example.human.AbstractHumanFactory#createHuman(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Human> T createHuman(Class<T> c) {
		Human human = null; 
		try {
			human = (Human)Class.forName(c.getName()).newInstance();
		} catch (Exception e) {
			System.out.println("error");
		}
		return (T)human;
	}
	
}
