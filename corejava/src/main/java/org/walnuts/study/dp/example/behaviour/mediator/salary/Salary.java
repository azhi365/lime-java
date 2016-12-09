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
public class Salary extends AbsColleague implements ISalary {

	/**
	 * 
	 * 
	 * 
	 * @param mediator
	 */
	public Salary(AbsMediator mediator) {
		super(mediator);
	}

	/* (non-Javadoc)
	 * @see dp.example.behaviour.mediator.salary.ISalary#decreaseSalary()
	 */
	@Override
	public void decreaseSalary() {
		super.mediator.down(this);
	}

	/* (non-Javadoc)
	 * @see dp.example.behaviour.mediator.salary.ISalary#increaseSalary()
	 */
	@Override
	public void increaseSalary() {
		super.mediator.up(this);
	}

}
