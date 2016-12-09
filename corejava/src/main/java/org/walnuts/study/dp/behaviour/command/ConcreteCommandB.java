/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午11:31:56
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.behaviour.command;

/**
 * 具体命令B
 * @author YZhi
 * @since 1.0
 */
public class ConcreteCommandB extends Command {
	private Receiver receiver;
	public ConcreteCommandB(Receiver receiver){
		this.receiver = receiver;
	}
	/* (non-Javadoc)
	 * @see behaviour.command.Command#execute()
	 */
	@Override
	public void execute() {
		this.receiver.doSomething();
	}
}
