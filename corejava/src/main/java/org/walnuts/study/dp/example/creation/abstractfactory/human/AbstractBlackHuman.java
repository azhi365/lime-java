/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午04:10:32
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.abstractfactory.human;

/**
 * 黑色人种
 * @author YZhi
 * @since 1.0
 */
public abstract class AbstractBlackHuman implements Human{

	/* (non-Javadoc)
	 * @see creation.abstractfactory.example.human.Human#getColor()
	 */
	@Override
	public void getColor() {
		System.out.println("Black");
	}

	/* (non-Javadoc)
	 * @see creation.abstractfactory.example.human.Human#talk()
	 */
	@Override
	public void talk() {
		System.out.println("Black talk");
	}
}
