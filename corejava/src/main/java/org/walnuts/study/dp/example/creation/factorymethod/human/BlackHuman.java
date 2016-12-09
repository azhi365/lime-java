/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午02:50:51
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.factorymethod.human;

/**
 * 黑色人种
 * @author YZhi
 * @since 1.0
 */
public class BlackHuman implements Human {

	/* (non-Javadoc)
	 * @see creation.factorymethod.example.human.Human#getColor()
	 */
	@Override
	public void getColor() {
		System.out.println("black");
	}

	/* (non-Javadoc)
	 * @see creation.factorymethod.example.human.Human#talk()
	 */
	@Override
	public void talk() {
		System.out.println("black talk");
	}

}
