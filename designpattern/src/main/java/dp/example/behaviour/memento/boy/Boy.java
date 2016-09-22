/**
 * @author yzhi
 * @date 2012-1-29 下午03:10:04
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.memento.boy;

/**
 * 男孩状态类
 * @author YZhi
 * @since 1.0
 */
public class Boy {
	private String state = "";
	public void changeState(){
		this.state = "bad mood";
	}
	
	public Memento createMemento(){
		return new Memento(this.state);
	}
	
	public void restoreMemento(Memento memento){
		this.setState(memento.getState());
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
