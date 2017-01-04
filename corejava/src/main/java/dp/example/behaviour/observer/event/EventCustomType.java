/**
 * 
 * @author YZhi
 * @date 2012-5-30
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.behaviour.observer.event;

/**
 * 事件处理枚举
 * @author YZhi
 * @since 1.0
 */
public enum EventCustomType {
	NEW(1),
	DEL(2),
	EDIT(3),
	CLONE(4);
	
	private int value = 0;
	
	/**
	 * 
	 * @param value
	 */
	private EventCustomType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
