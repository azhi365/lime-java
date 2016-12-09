/**
 * 
 * @author YZhi
 * @date 2012-5-16
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.behaviour.command;

/**
 * 完美的命令模式
 * @author YZhi
 * @since 1.0
 */
public abstract class PerfectCommand {
	protected final Receiver receiver;
	public PerfectCommand(Receiver receiver){
		this.receiver = receiver;
	}
	public abstract void execute();
}
