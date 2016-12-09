/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午04:13:27
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.abstractfactory.human;

/**
 * 黄色女性人种
 * @author YZhi
 * @since 1.0
 */
public class FemaleYellowHuman extends AbstractYellowHuman {

	/* (non-Javadoc)
	 * @see creation.abstractfactory.example.human.Human#getSex()
	 */
	@Override
	public void getSex() {
		System.out.println("Yellow Female");
	}

}
