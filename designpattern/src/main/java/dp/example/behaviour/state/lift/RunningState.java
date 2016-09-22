/**
 * @author yzhi
 * @date 2012-1-29 下午05:41:31
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.state.lift;

/**
 * 运行状态
 * @author YZhi
 * @since 1.0
 */
public class RunningState extends LiftState {

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
		
	}

	/* (non-Javadoc)
	 * @see behaviour.state.example.lift.LiftState#run()
	 */
	@Override
	public void run() {
		System.out.println("the door is running");
	}

	/* (non-Javadoc)
	 * @see behaviour.state.example.lift.LiftState#stop()
	 */
	@Override
	public void stop() {
		
	}
}
