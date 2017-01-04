/**
 * @author yzhi
 * @date 2012-1-29 上午09:58:35
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.iterator.project;

import java.util.ArrayList;

/**
 * 项目迭代实现
 * @author YZhi
 * @since 1.0
 */
public class ProjectIterator implements IProjectIterator<IProject> {
	private ArrayList<IProject> projectList = new ArrayList<IProject>();
	private int currentItem = 0;
	
	
	/**
	 * 
	 * 
	 * 
	 * @param projectList
	 */
	public ProjectIterator(ArrayList<IProject> projectList) {
		this.projectList = projectList;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		boolean b = true;
		if(this.currentItem >= projectList.size() || this.projectList.get(this.currentItem) == null){
			b = false;
		}
		return b;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	@Override
	public IProject next() {
		return this.projectList.get(this.currentItem++);
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove() {
		
	}

}
