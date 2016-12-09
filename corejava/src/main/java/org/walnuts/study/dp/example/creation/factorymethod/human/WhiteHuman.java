/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午02:52:29
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.factorymethod.human;

/**
 * 白色 人种
 * @author YZhi
 * @since 1.0
 */
public class WhiteHuman implements Human {

	/* (non-Javadoc)
	 * @see creation.factorymethod.example.human.Human#getColor()
	 */
	@Override
	public void getColor() {
		System.out.println("White");
	}

	/* (non-Javadoc)
	 * @see creation.factorymethod.example.human.Human#talk()
	 */
	@Override
	public void talk() {
		System.out.println("White talk");
	}

}
