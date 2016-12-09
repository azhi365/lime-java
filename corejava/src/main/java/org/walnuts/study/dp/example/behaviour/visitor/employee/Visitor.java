/**
 * @author yzhi
 * @date 2012-1-29 下午04:24:02
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.visitor.employee;

/**
 * 访问者实现
 * @author YZhi
 * @since 1.0
 */
public class Visitor implements IVisitor {
	private final static int MANAGER_COEFFICIENT = 5;
	private final static int COMMONEMPLOYEE_COEFFICIENT = 2;
	private int commonTotalSalary= 0;
	private int managerTotalSalary = 0;
	/* (non-Javadoc)
	 * @see behaviour.visitor.employee.IVisitor#visit(behaviour.visitor.employee.CommonEmployee)
	 */
	@Override
	public void visit(CommonEmployee commonEmployee) {
		System.out.println(this.getCommonEmployeeInfo(commonEmployee));
	}

	/* (non-Javadoc)
	 * @see behaviour.visitor.employee.IVisitor#visit(behaviour.visitor.employee.Manager)
	 */
	@Override
	public void visit(Manager manager) {
		System.out.println(this.getManagerInfo(manager));
	}
	
	/* (non-Javadoc)
	 * @see behaviour.visitor.example.employee.IVisitor#getTotalSalary()
	 */
	@Override
	public int getTotalSalary() {
		return this.managerTotalSalary + this.commonTotalSalary;
	}
	
	@SuppressWarnings("unused")
	private void calManagerSalary(int salary) {
		this.managerTotalSalary += salary*MANAGER_COEFFICIENT;
	}
	@SuppressWarnings("unused")
	private void calCommonSalary(int salary){
		this.commonTotalSalary += salary*COMMONEMPLOYEE_COEFFICIENT;
	}
	
	private String getBasicInfo(Employee employee){
		String info = "name: " + employee.getName() + "\t";
		info = info + "gender: " + employee.getSex() + "\t";
		info = info + "salary: " + employee.getSalary() + "\t";
		return info;
	}
	
	private String getManagerInfo(Manager manager){
		String info = this.getBasicInfo(manager);
		info = info + manager.getPerformance() + "\t";
		return info;
	}
	
	private String getCommonEmployeeInfo(CommonEmployee commonEmployee){
		String info  = this.getBasicInfo(commonEmployee);
		info = info + commonEmployee.getJob() + "\t";
		return info;
	}

}
