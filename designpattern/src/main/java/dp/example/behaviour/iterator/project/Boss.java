/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午10:01:59
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.iterator.project;

import org.junit.Test;

/**
 * 老大看项目报表
 * @author YZhi
 * @since 1.0
 */
public class Boss {
	@Test
	public void testProject(){
		IProject project = new Project();
		project.add("name1", 1, 10);
		project.add("name2", 2, 20);
		project.add("name3", 3, 30);
		project.add("name4", 4, 40);
		IProjectIterator<IProject> projectIterator = project.iterator();
		while (projectIterator.hasNext()){
			System.out.println(projectIterator.next().getProjectInfo());
		}
	}
}
