/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午03:37:07
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.behaviour.memento.multi;

/**
 * 发起人角色
 * @author YZhi
 * @since 1.0
 */
public class Originator {
	private String state1 = "";
	private String state2 = "";
	private String state3 = "";
	public Memento createMemento(){
		return new Memento(BeanUtils.backupProp(this));
	}
	
	public void restoreMemento(Memento memento){
		BeanUtils.restoreProp(this, memento.getStateMap());
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "state1=" + this.state1 + " state2=" + this.state2 + " state3=" + this.state3;
	}
	//----------------------------------
	/**
	 * @return the state1
	 */
	public String getState1() {
		return state1;
	}
	/**
	 * @param state1 the state1 to set
	 */
	public void setState1(String state1) {
		this.state1 = state1;
	}
	/**
	 * @return the state2
	 */
	public String getState2() {
		return state2;
	}
	/**
	 * @param state2 the state2 to set
	 */
	public void setState2(String state2) {
		this.state2 = state2;
	}
	/**
	 * @return the state3
	 */
	public String getState3() {
		return state3;
	}
	/**
	 * @param state3 the state3 to set
	 */
	public void setState3(String state3) {
		this.state3 = state3;
	}
	
}
