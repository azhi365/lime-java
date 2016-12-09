/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午03:26:35
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.behaviour.memento.clone;
/**
 * 备忘录管理者
 * @author YZhi
 * @since 1.0
 */
public class Caretaker {
	private Originator originator;

	/**
	 * @return the originator
	 */
	public Originator getOriginator() {
		return originator;
	}

	/**
	 * @param originator the originator to set
	 */
	public void setOriginator(Originator originator) {
		this.originator = originator;
	}
	
}
