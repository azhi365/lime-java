/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午04:18:58
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.abstractfactory.human;

import org.junit.Test;

/**
 * 女娲类
 * @author YZhi
 * @since 1.0
 */
public class NvWa {
	/**
	 *抽象工厂测试类
	 */
	@Test
	public void testAbstractFactory(){
		HumanFactory maleHumanFactory = new MaleFactory();
		HumanFactory femaleHumanFactory = new FemaleFactory();
		Human maleYellowHuman = maleHumanFactory.createYellowHuman();
		Human femaleWhiteHuman = femaleHumanFactory.createWhiteHuman();
		maleYellowHuman.getColor();
		maleYellowHuman.getSex();
		maleYellowHuman.talk();
		femaleWhiteHuman.getColor();
		femaleWhiteHuman.getSex();
		femaleWhiteHuman.talk();
		
	}
}
