/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午04:14:50
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.visitor.employee;

/**
 * 抽象员工
 * @author YZhi
 * @since 1.0
 */
public abstract class Employee {
	public final static int MALE = 0;
	public final static int FEMALE = 1;
	private String name;
	private String salary;
	private int sex;
	public final void report(){
		String info = "name: " + this.name + "\t";
		info = info + "gender: " + this.sex + "\t";
		info = info + "salary: " + this.salary + "\t";
		info = info + this.getOtherInfo();
	}
	
	/**
	 * @return
	 */
	protected abstract String getOtherInfo();
	
	public abstract void accept(IVisitor visitor);

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the salary
	 */
	public String getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}
	/**
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}
	
}
