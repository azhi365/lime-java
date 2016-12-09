/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午11:33:13
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.behaviour.command;

/**
 * 调用者角色
 * @author YZhi
 * @since 1.0
 */
public class Invoker {
	private Command command;
	
	/**
	 * @param command the command to set
	 */
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void action() {
		this.command.execute();
	}
}
