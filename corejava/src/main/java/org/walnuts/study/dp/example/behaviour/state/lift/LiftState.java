/**
 * @author yzhi
 * @date 2012-1-29 下午05:36:24
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.state.lift;

/**
 * 抽象电梯状态
 * @author YZhi
 * @since 1.0
 */
public abstract class LiftState {
	protected Context context;
	public abstract void open();
	public abstract void close();
	public abstract void run();
	public abstract void stop();
	
	/**
	 * @param context the context to set
	 */
	public void setContext(Context context) {
		this.context = context;
	}
	
}
