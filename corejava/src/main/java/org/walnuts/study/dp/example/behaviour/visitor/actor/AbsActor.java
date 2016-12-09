/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午05:16:45
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.visitor.actor;

/**
 * 抽象演员
 * @author YZhi
 * @since 1.0
 */
public abstract class AbsActor {
	public void act(Role role){
		System.out.println("any role");
	}
	public void act(KungFuRole role){
		System.out.println("kungfu role");
	}
}
