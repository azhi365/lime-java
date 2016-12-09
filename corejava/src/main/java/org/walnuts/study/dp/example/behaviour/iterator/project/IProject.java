/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午09:52:41
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.iterator.project;

/**
 * 项目接口
 * @author YZhi
 * @since 1.0
 */
public interface IProject {
	public void add(String name,int num ,int cost);
	public String getProjectInfo();
	public IProjectIterator<IProject> iterator();
}
