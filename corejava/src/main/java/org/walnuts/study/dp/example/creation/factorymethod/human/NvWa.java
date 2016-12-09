/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午02:56:41
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.factorymethod.human;

import org.junit.Test;

/**
 * 女娲类
 * @author YZhi
 * @since 1.0
 */
public class NvWa {
	/**
	 *
	 *一般工厂
	 */
	@Test
	public void testHuman(){
		AbstractHumanFactory YinYangLu = new HumanFactory();
		Human whiteHuman = YinYangLu.createHuman(WhiteHuman.class);
		whiteHuman.getColor();
		whiteHuman.talk();
		Human blackHuman = YinYangLu.createHuman(BlackHuman.class);
		blackHuman.getColor();
		blackHuman.talk();
		Human yellowHuman = YinYangLu.createHuman(YellowHuman.class);
		yellowHuman.getColor();
		yellowHuman.talk();
	}
	/**
	 *简单工厂，也叫静态工厂
	 */
	@Test
	public void testFacotrySimple(){
		Human whiteHuman = HumanFactorySimple.createHuman(WhiteHuman.class);
		whiteHuman.getColor();
		whiteHuman.talk();
	}
	
	/**
	 *多个工厂类
	 */
	@Test
	public void testFactoryMulti(){
		Human whitehHuman = (new WhiteHumanFacotry()).createHuman();
		whitehHuman.getColor();
		whitehHuman.talk();
		
		Human blackHuman = (new BlackHumanFactory()).createHuman();
		blackHuman.getColor();
		blackHuman.talk();
	}
}
