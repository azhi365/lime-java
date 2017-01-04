/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午03:38:33
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.behaviour.memento.multi;

import java.util.HashMap;

/**
 * 备忘录角色
 * @author YZhi
 * @since 1.0
 */
public class Memento {
	private HashMap<String, Object> stateMap;

	/**
	 * 
	 * 
	 * 
	 * @param stateMap
	 */
	public Memento(HashMap<String, Object> stateMap) {
		super();
		this.stateMap = stateMap;
	}

	/**
	 * @return the stateMap
	 */
	public HashMap<String, Object> getStateMap() {
		return stateMap;
	}

	/**
	 * @param stateMap the stateMap to set
	 */
	public void setStateMap(HashMap<String, Object> stateMap) {
		this.stateMap = stateMap;
	}
	
}
