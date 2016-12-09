/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午03:01:30
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.command.group;

/**
 * 负责人
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
	public void action(){
		this.command.execute();
	}
}
