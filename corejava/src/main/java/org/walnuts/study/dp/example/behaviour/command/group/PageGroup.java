/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午02:54:24
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.command.group;

/**
 * 美工组
 * @author YZhi
 * @since 1.0
 */
public class PageGroup extends Group {

	/* (non-Javadoc)
	 * @see behaviour.command.exmaple.group.Group#add()
	 */
	@Override
	public void add() {
		System.out.println("add a page");
	}

	/* (non-Javadoc)
	 * @see behaviour.command.exmaple.group.Group#change()
	 */
	@Override
	public void change() {
		System.out.println("change a page");
	}

	/* (non-Javadoc)
	 * @see behaviour.command.exmaple.group.Group#delete()
	 */
	@Override
	public void delete() {
		System.out.println("delete a page");	}

	/* (non-Javadoc)
	 * @see behaviour.command.exmaple.group.Group#find()
	 */
	@Override
	public void find() {
		System.out.println("find a page");
	}

	/* (non-Javadoc)
	 * @see behaviour.command.exmaple.group.Group#plan()
	 */
	@Override
	public void plan() {
		System.out.println("plan a page");
	}

}
