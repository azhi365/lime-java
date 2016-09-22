/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午03:26:35
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.behaviour.memento.multi;

import java.util.HashMap;

/**
 * 备忘录管理者
 * @author YZhi
 * @since 1.0
 */
public class Caretaker {
	private HashMap<String, Memento> memMap = new HashMap<String, Memento>();
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

	/**
	 * @return the memMap
	 */
	public HashMap<String, Memento> getMemMap() {
		return memMap;
	}

	/**
	 * @param memMap the memMap to set
	 */
	public void setMemMap(HashMap<String, Memento> memMap) {
		this.memMap = memMap;
	}
	
	
}
