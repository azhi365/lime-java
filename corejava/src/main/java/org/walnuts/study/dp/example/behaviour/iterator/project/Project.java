/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午09:54:01
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.iterator.project;

import java.util.ArrayList;

/**
 * 项目信息实现
 * @author YZhi
 * @since 1.0
 */
public class Project implements IProject {
	private ArrayList<IProject> projectList = new ArrayList<IProject>();
	private String name = "";
	private int num = 0;
	private int cost = 0;
	public Project(){
		
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param projectList
	 * @param name
	 * @param num
	 * @param cost
	 */
	public Project(String name, int num,int cost) {
		super();
		this.name = name;
		this.num = num;
		this.cost = cost;
	}

	/* (non-Javadoc)
	 * @see behaviour.iterator.project.IProject#add(java.lang.String, int, int)
	 */
	@Override
	public void add(String name, int num, int cost) {
		this.projectList.add(new Project(name, num, cost));
	}

	/* (non-Javadoc)
	 * @see behaviour.iterator.project.IProject#getProjectInfo()
	 */
	@Override
	public String getProjectInfo() {
		String info = "";
		info = info + "project name is " + this.name;
		info = info + "project num is " + this.num;
		info = info + "project cost is " + this.cost;
		return info;
	}

	/* (non-Javadoc)
	 * @see behaviour.iterator.project.IProject#iterator()
	 */
	@Override
	public IProjectIterator<IProject> iterator() {
		return new ProjectIterator(this.projectList);
	}

}
