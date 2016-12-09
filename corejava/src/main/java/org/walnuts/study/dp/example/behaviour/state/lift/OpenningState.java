/**
 * @author yzhi
 * @date 2012-1-29 下午05:38:41
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.state.lift;

/**
 * 开门状态
 * @author YZhi
 * @since 1.0
 */
public class OpenningState extends LiftState {

	/* (non-Javadoc)
	 * @see behaviour.state.example.lift.LiftState#close()
	 */
	@Override
	public void close() {
		super.context.setLiftState(Context.CLOSING_STATE);
		super.context.getLiftState().close();
	}

	/* (non-Javadoc)
	 * @see behaviour.state.example.lift.LiftState#open()
	 */
	@Override
	public void open() {
		super.context.setLiftState(Context.OPENNING_STATE);
		System.out.println("the door is open");
	}

	/* (non-Javadoc)
	 * @see behaviour.state.example.lift.LiftState#run()
	 */
	@Override
	public void run() {
		
	}

	/* (non-Javadoc)
	 * @see behaviour.state.example.lift.LiftState#stop()
	 */
	@Override
	public void stop() {
		
	}

}
