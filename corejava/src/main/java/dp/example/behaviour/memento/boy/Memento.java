/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午03:11:08
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.memento.boy;

/**
 * 备忘录
 * @author YZhi
 * @since 1.0
 */
public class Memento {
	private String state = "";
	

	/**
	 * 
	 * 
	 * 
	 * @param state
	 */
	public Memento(String state) {
		this.state = state;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	
}
