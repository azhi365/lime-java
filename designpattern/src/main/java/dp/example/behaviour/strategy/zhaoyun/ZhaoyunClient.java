/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午04:31:03
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.strategy.zhaoyun;

import org.junit.Test;

/**
 * 使用妙计
 * @author yzhi
 * @date 2012-1-20
 */
public class ZhaoyunClient {
	@Test
	public void testStrategy(){
		Context context;
		context = new Context(new BackDoor());
		context.operate();
		context = new Context(new GreenLight());
		context.operate();
		context = new Context(new BlockEnemy());
		context.operate();
	}
}
