/**
 * @author yzhi
 * @date 2012-1-29 下午04:19:49
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.visitor.employee;

/**
 * 管理阶层
 * @author YZhi
 * @since 1.0
 */
public class Manager extends Employee {
	private String performance;
	
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
		return "performance: " + this.performance + "\t";
	}
	/**
	 * @return the performance
	 */
	public String getPerformance() {
		return performance;
	}
	/**
	 * @param performance the performance to set
	 */
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	

}
