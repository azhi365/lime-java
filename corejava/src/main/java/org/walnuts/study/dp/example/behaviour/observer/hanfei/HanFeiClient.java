/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午02:44:12
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.observer.hanfei;

import org.junit.Test;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class HanFeiClient {
	@Test
	public void testHanFei(){
		LiSi liSi = new LiSi();
		WangSi wangSi = new WangSi();
		LiuSi liuSi = new LiuSi();
		HanFeiZi hanFeiZi = new HanFeiZi();
		hanFeiZi.addObserver(liSi);
		hanFeiZi.addObserver(wangSi);
		hanFeiZi.addObserver(liuSi);
		hanFeiZi.haveBreakfast();
	}
}
