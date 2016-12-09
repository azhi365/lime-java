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
 * 
 * @author YZhi
 * @since 1.0
 */
public class Position extends AbsColleague implements IPosition {
	public Position(AbsMediator mediator) {
		super(mediator);
	}

	/* (non-Javadoc)
	 * @see dp.example.behaviour.mediator.salary.IPosition#demote()
	 */
	@Override
	public void demote() {
		super.mediator.down(this);
	}

	/* (non-Javadoc)
	 * @see dp.example.behaviour.mediator.salary.IPosition#promote()
	 */
	@Override
	public void promote() {
		super.mediator.up(this);
	}

}
