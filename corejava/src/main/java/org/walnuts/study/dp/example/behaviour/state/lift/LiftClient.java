/**
 * @author yzhi
 * @date 2012-1-29 下午05:59:13
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.state.lift;

import org.junit.Test;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class LiftClient {
	@Test
	public void testLift(){
		Context context = new Context();
		context.setLiftState(new ClosingState());
		context.open();
		context.close();
		context.run();
		context.stop();
	}
}
