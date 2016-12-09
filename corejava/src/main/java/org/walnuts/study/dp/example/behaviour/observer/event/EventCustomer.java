/**
 * 
 * @author YZhi
 * @date 2012-5-30
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.observer.event;

import java.util.Vector;

/**
 * 抽象的事件处理者
 * @author YZhi
 * @since 1.0
 */
public abstract class EventCustomer {
	private Vector<EventCustomType> customType = new Vector<EventCustomType>();

	/**
	 * 
	 * @param type
	 */
	public EventCustomer(EventCustomType type) {
		this.addCustomType(type);
	}
	

	public void addCustomType(EventCustomType type){
		customType.add(type);
	}
	
	public Vector<EventCustomType> getCustomType() {
		return customType;
	}
	
	public abstract void exec(ProductEvent event);
	
	
}
