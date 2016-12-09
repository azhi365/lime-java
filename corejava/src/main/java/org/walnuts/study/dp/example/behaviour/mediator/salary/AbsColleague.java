/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.mediator.salary;

/**
 * 抽象同事类
 * @author YZhi
 * @since 1.0
 */
public abstract class AbsColleague {
	protected AbsMediator mediator;

	/**
	 * 
	 * 
	 * 
	 * @param mediator
	 */
	public AbsColleague(AbsMediator mediator) {
		super();
		this.mediator = mediator;
	}
	
}
