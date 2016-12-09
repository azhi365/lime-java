/**
 * @author yzhi
 * @date 2012-1-30 上午10:57:48
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.bridge.corp;

import org.junit.Test;
/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class CorpClient {
	@Test
	public void testCorp(){
		House house = new House();
		HouseCorp houseCorp = new HouseCorp(house);
		houseCorp.makeMoney();
		ShanZhaiCorp shanZhaiCorp = new ShanZhaiCorp(new Clothes());
		shanZhaiCorp.makeMoney();
	}
}
