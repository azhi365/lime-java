/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午03:21:00
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.behaviour.memento.clone;
/**
 * 融合备忘录的发起人角色，发起人自主备份和恢复
 * @author YZhi
 * @since 1.0
 */
public class Originator implements Cloneable {
	private String state = "";
	private Originator backup;
	
	public void createMemento(){
		this.backup =  this.clone();
	}
	
	public void restoreMemento(Originator originator){
		this.setState(this.backup.getState());
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Originator clone(){
		Originator originator = null;
		try {
			originator = (Originator)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return originator;
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
