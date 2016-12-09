/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午03:17:14
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.memento.boy;

/**
 * 备忘录管理者
 * @author YZhi
 * @since 1.0
 */
public class Caretaker {
	private Memento memento;

	/**
	 * @return the memento
	 */
	public Memento getMemento() {
		return memento;
	}

	/**
	 * @param memento the memento to set
	 */
	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
}
