/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午10:54:13
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.composite.corp;

import java.util.ArrayList;

/**
 * 
 * 树枝节点
 * @author yzhi
 * @date 2012-1-29
 * @version 
 */
public class Branch extends Corp {
	ArrayList<Corp> subordinateList = new ArrayList<Corp>();
	/**
	 * 
	 * 
	 * 
	 * @param name
	 * @param position
	 * @param salary
	 */
	public Branch(String name, String position, int salary) {
		super(name, position, salary);
	}
	
	public void addSubordinate(Corp corp){
		this.subordinateList.add(corp);
	}
	
	public ArrayList<Corp> getSubordinate(){
		return this.subordinateList;
	}
	
}
