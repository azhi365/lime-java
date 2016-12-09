/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.state.life;

/**
 * 人的抽象状态
 * @author YZhi
 * @since 1.0
 */
public abstract class HumanState {
	protected Human human;

	public void setHuman(Human human) {
		this.human = human;
	}
	
	public abstract void work();
	
}
