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
public abstract class AbsMediator {
	protected final ISalary salary;
	
	protected final IPosition position;
	
	protected final ITax tax;

	/**
	 * 
	 * 
	 * 
	 * @param salary
	 * @param position
	 * @param tax
	 */
	public AbsMediator() {
		this.salary = new Salary(this);
		this.position = new Position(this);
		this.tax = new Tax(this);
	}
	
	public abstract void up(ISalary salary);
	public abstract void up(ITax tax);
	public abstract void up(IPosition position);
	public abstract void down(ISalary salary);
	public abstract void down(ITax tax);
	public abstract void down(IPosition position);
	
}
