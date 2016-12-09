/**
 * @author yzhi
 * @date 2012-1-29 下午05:16:05
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.visitor.actor;

/**
 * 功夫角色
 * @author YZhi
 * @since 1.0
 */
public class KungFuRole implements Role {

	/* (non-Javadoc)
	 * @see behaviour.visitor.example.actor.Role#accept(behaviour.visitor.example.actor.AbsActor)
	 */
	@Override
	public void accept(AbsActor actor) {
		actor.act(this);
	}
	
}
