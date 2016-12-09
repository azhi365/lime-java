/**
 * 
 * @author yzhi
 * @date 2012-1-30 上午10:20:19
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.flyweight.sign;

/**
 * 外部状态类
 * @author YZhi
 * @since 1.0
 */
public class ExtrinsicState {
	private String subject;
	private String location;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ExtrinsicState){
			ExtrinsicState state = (ExtrinsicState)obj;
			return state.getLocation().equals(this.location) && state.getSubject().equals(this.subject);
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.subject.hashCode() + this.location.hashCode();
	}
	
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
}
