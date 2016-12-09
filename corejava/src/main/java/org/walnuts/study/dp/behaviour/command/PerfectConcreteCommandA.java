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
 * 具体命令A
 * @author YZhi
 * @since 1.0
 */
public class PerfectConcreteCommandA extends PerfectCommand {

	public PerfectConcreteCommandA(){
		super(new ConcreteReceiverA());
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param receiver
	 */
	public PerfectConcreteCommandA(Receiver receiver) {
		super(receiver);
	}

	/* (non-Javadoc)
	 * @see dp.behaviour.command.PerfectCommand#execute()
	 */
	@Override
	public void execute() {
		super.receiver.doSomething();
	}

}
