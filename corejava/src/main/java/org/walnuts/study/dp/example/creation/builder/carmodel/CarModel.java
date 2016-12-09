/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午05:04:34
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.builder.carmodel;

import java.util.ArrayList;

/**
 * 车辆模型的抽象类
 * @author YZhi
 * @since 1.0
 */
public abstract class CarModel {
	private ArrayList<String> sequence = new ArrayList<String>();
	protected abstract void start();
	protected abstract void stop();
	protected abstract void alarm();
	protected abstract void engineBoom();
	final public void run(){
		for (int i = 0; i < sequence.size(); i++) {
			String actionName = this.sequence.get(i);
			if(actionName.equalsIgnoreCase("start")){
				this.start();
			}else if(actionName.equalsIgnoreCase("stop")) {
				this.stop();
			}else if (actionName.equalsIgnoreCase("alarm")) {
				this.alarm();
			}else if(actionName.equalsIgnoreCase("engine boom")) {
				this.engineBoom();
			}
		}
	} 
	final public void setSequence(ArrayList<String> sequence){
		this.sequence = sequence;
	}
}
