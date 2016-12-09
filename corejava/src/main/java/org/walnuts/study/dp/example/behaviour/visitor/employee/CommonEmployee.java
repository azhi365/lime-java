/**
 * @author yzhi
 * @date 2012-1-29 下午04:18:58
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.visitor.employee;

/**
 * 普通员工
 * @author YZhi
 * @since 1.0
 */
public class CommonEmployee extends Employee {
	private String job;
	/* (non-Javadoc)
	 * @see behaviour.visitor.employee.Employee#accept(behaviour.visitor.employee.IVisitor)
	 */
	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
	
	/* (non-Javadoc)
	 * @see behaviour.visitor.employee.Employee#getOtherInfo()
	 */
	@Override
	protected String getOtherInfo() {
		
		return "job: " + this.job + "\t";
	}
	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}
	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}
	

}
