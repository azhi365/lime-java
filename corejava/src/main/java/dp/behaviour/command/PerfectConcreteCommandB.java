/**
 * 
 * @author YZhi
 * @date 2012-5-16
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.behaviour.command;

/**
 * 具体命令B
 * @author YZhi
 * @since 1.0
 */
public class PerfectConcreteCommandB extends PerfectCommand {

	public PerfectConcreteCommandB(){
		super(new ConcreteReceiverB());
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param receiver
	 */
	public PerfectConcreteCommandB(Receiver receiver) {
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
