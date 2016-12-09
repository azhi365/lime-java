/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午10:49:31
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.composite.corp;

/**
 * 抽象公司职员
 * @author YZhi
 * @since 1.0
 */
public abstract class Corp {
	private String name = "";
	private String position = "";
	private int salary = 0;
	
	public Corp(String name, String position, int salary) {
		super();
		this.name = name;
		this.position = position;
		this.salary = salary;
	}
	public String getInfo(){
		String info = "";
		info = "name:" + this.name + "\t";
		info = info + "post:" + this.position + "\t";
		info = info + "salary:" + this.salary;
		return info;
	}
}
