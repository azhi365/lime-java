/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午02:49:47
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.observer.hanfeiinjava;

import org.junit.Test;

/**
 * Java中的观察者模式
 * @author yzhi
 * @date 2012-1-29
 * @version 
 */
public class HanFeiClient {
	@Test
	public void testHanFei(){
		HanFeiZi hanFeiZi = new HanFeiZi();
		LiSi liSi = new LiSi();
		hanFeiZi.addObserver(liSi);
		hanFeiZi.haveBreakfast();
	}
}
