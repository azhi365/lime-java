/**
 * @author yzhi
 * @date 2012-1-29 下午05:18:57
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.visitor.actor;

/**
 * 老演员
 * @author YZhi
 * @since 1.0
 */
public class OldActor extends AbsActor {
	/* (non-Javadoc)
	 * @see behaviour.visitor.example.actor.AbsActor#act(behaviour.visitor.example.actor.KungFuRole)
	 */
	@Override
	public void act(KungFuRole role) {
		System.out.println("no kungfu role");
	}
}
