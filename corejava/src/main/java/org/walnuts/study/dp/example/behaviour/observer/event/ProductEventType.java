/**
 * 
 * @author YZhi
 * @date 2012-5-30
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.observer.event;

/**
 * 事件类型定义
 * @author YZhi
 * @since 1.0
 */
public enum ProductEventType {
	NEW_PRODUCT(1),
	DEL_RPODUCT(2),
	EDIT_PRODUCT(3),
	CLONE_PRODUCT(4);
	private int value = 0;
	private ProductEventType(int value){
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
