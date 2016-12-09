/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午04:29:19
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.templete.hummer;

/**
 * 抽象悍马模型
 * @author YZhi
 * @since 1.0
 */
public abstract class HummerModel {
	protected abstract void start();
	protected abstract void stop();
	protected abstract void alarm();
	protected abstract void engineBoom();
	final public void run(){
		this.start();
		this.engineBoom();
		if(this.isAlarm()){
			this.alarm();
		}
		this.stop();
	}
	/**
	 *钩子方法
	 * @return
	 */
	protected boolean isAlarm(){
		return true;
	}
}
