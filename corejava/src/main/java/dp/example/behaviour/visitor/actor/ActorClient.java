/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午05:23:22
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.visitor.actor;

import org.junit.Test;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class ActorClient {
	@Test
	public void testActor(){
		AbsActor actor = new OldActor();
		Role role = new KungFuRole();
		role.accept(actor);
	}
}
