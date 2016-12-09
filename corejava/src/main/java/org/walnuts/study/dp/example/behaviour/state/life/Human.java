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
 * 环境角色
 * @author YZhi
 * @since 1.0
 */
public class Human {
	public static final HumanState CHILD_STATE = new ChildState();
	public static final HumanState ADULT_STATE = new AdultState();
	public static final HumanState OLD_STATE = new OldState();
	
	private HumanState state;


	public void setState(HumanState state) {
		this.state = state;
		this.state.setHuman(this);
	}
	public void work(){
		this.state.work();
	}
	
}
