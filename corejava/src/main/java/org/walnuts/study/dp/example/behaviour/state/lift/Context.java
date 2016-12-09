/**
 * @author yzhi
 * @date 2012-1-29 下午05:36:04
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.state.lift;

/**
 * 上下文类
 * @author YZhi
 * @since 1.0
 */
public class Context {
	public final static OpenningState OPENNING_STATE = new OpenningState();
	public final static ClosingState CLOSING_STATE = new ClosingState();
	public final static RunningState RUNNING_STATE = new RunningState();
	public final static StoppingState STOPPING_STATE = new StoppingState();
	private LiftState liftState;
	
	public void open(){
		this.liftState.open();
	}
	
	public void close(){
		this.liftState.close();
	}
	
	public void run(){
		this.liftState.run();
	}
	
	public void stop(){
		this.liftState.stop();
	}
	
	/**
	 * @return the liftState
	 */
	public LiftState getLiftState() {
		return liftState;
	}
	/**
	 * @param liftState the liftState to set
	 */
	public void setLiftState(LiftState liftState) {
		this.liftState = liftState;
		this.liftState.setContext(this);
	}
	
}
