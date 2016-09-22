/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午05:40:40
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.state.lift;

/**
 * 关闭状态
 * @author YZhi
 * @since 1.0
 */
public class ClosingState extends LiftState {

	/* (non-Javadoc)
	 * @see behaviour.state.example.lift.LiftState#close()
	 */
	@Override
	public void close() {
		System.out.println("the door is closed");
	}

	/* (non-Javadoc)
	 * @see behaviour.state.example.lift.LiftState#open()
	 */
	@Override
	public void open() {
		super.context.setLiftState(Context.OPENNING_STATE);
	}

	/* (non-Javadoc)
	 * @see behaviour.state.example.lift.LiftState#run()
	 */
	@Override
	public void run() {
		super.context.setLiftState(Context.RUNNING_STATE);
		super.context.getLiftState().run();
	}

	/* (non-Javadoc)
	 * @see behaviour.state.example.lift.LiftState#stop()
	 */
	@Override
	public void stop() {
		super.context.getLiftState().stop();
	}

}
