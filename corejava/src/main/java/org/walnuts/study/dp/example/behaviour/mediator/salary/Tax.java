/**
 * 
 * @author YZhi
 * @date 2012-5-29
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.mediator.salary;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class Tax extends AbsColleague implements ITax {

	public Tax(AbsMediator mediator) {
		super(mediator);
	}

	/* (non-Javadoc)
	 * @see dp.example.behaviour.mediator.salary.ITax#drop()
	 */
	@Override
	public void drop() {
		super.mediator.down(this);
	}

	/* (non-Javadoc)
	 * @see dp.example.behaviour.mediator.salary.ITax#raise()
	 */
	@Override
	public void raise() {
		super.mediator.up(this);
	}

}
