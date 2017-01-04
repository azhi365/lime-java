/**
 * @author yzhi
 * @date 2012-1-29 下午05:41:55
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.state.lift;

/**
 * 停止状态
 * @author YZhi
 * @since 1.0
 */
public class StoppingState extends LiftState {

	/* (non-Javadoc)
	 * @see behaviour.state.example.lift.LiftState#close()
	 */
	@Override
	public void close() {
		
	}

	/* (non-Javadoc)
	 * @see behaviour.state.example.lift.LiftState#open()
	 */
	@Override
	public void open() {
		super.context.setLiftState(Context.OPENNING_STATE);
		super.context.getLiftState().open();
	}

	/* (non-Javadoc)
	 * @see behaviour.state.example.lift.LiftState#run()
	 */
	@Override
	public void run() {
		super.context.setLiftState(Context.RUNNING_STATE);
		super.context.getLiftState().stop();
	}

	/* (non-Javadoc)
	 * @see behaviour.state.example.lift.LiftState#stop()
	 */
	@Override
	public void stop() {
		System.out.println("the door is stopped");
	}

}
