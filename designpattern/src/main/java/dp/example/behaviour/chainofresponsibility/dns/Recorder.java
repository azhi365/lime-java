/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.behaviour.chainofresponsibility.dns;

/**
 * 解析记录
 * @author YZhi
 * @since 1.0
 */
public class Recorder {
	private String domian;
	private String ip;
	private String owner;
	public String getDomian() {
		return domian;
	}
	public void setDomian(String domian) {
		this.domian = domian;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "domain is " + this.domian + "\n" + "ip is " + this.ip + "\n" + "owner is " + this.owner;
	}
}
