/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午02:55:39
 * @copyright 2012 haitian.com All rights reserved
 * @version 1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.command.group;

/**
 * 代码组
 * @author YZhi
 * @since 1.0
 */
public class CodeGroup extends Group {

	/* (non-Javadoc)
	 * @see behaviour.command.exmaple.group.Group#add()
	 */
	@Override
	public void add() {
		System.out.println("add a code");
	}

	/* (non-Javadoc)
	 * @see behaviour.command.exmaple.group.Group#change()
	 */
	@Override
	public void change() {
		System.out.println("change a code");
	}

	/* (non-Javadoc)
	 * @see behaviour.command.exmaple.group.Group#delete()
	 */
	@Override
	public void delete() {
		System.out.println("delete a code");
	}

	/* (non-Javadoc)
	 * @see behaviour.command.exmaple.group.Group#find()
	 */
	@Override
	public void find() {
		System.out.println("find a code");
	}

	/* (non-Javadoc)
	 * @see behaviour.command.exmaple.group.Group#plan()
	 */
	@Override
	public void plan() {
		System.out.println("plan a code");
	}

}
