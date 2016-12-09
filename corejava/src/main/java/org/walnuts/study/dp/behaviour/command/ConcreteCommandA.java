/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午11:30:03
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.behaviour.command;

/**
 * 具体命令A
 * @author YZhi
 * @since 1.0
 */
public class ConcreteCommandA extends Command {
	private Receiver receiver;
	public ConcreteCommandA(Receiver receiver){
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
