/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午09:56:46
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.prototype.mail;

/**
 * 邮件类
 * @author YZhi
 * @since 1.0
 */
public class Mail implements Cloneable {
	private String receiver;
	private String subject;
	private String appellation;
	private String contxt;
	private String tail;
	public Mail(AdvTemplete advTemplete){
		this.contxt = advTemplete.getAdvContext();
		this.subject = advTemplete.getAdvSubject();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Mail clone(){
		Mail mail = null;
		try {
			mail = (Mail)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return mail;
	}
	
	public void sendMail(){
		System.out.println(this.getSubject() + " " + this.getReceiver() + " successed");
	}
	
	
	//-----------------------------------------
	/**
	 * @return the receiver
	 */
	public String getReceiver() {
		return receiver;
	}
	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
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
	 * @return the appellation
	 */
	public String getAppellation() {
		return appellation;
	}
	/**
	 * @param appellation the appellation to set
	 */
	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}
	/**
	 * @return the contxt
	 */
	public String getContxt() {
		return contxt;
	}
	/**
	 * @param contxt the contxt to set
	 */
	public void setContxt(String contxt) {
		this.contxt = contxt;
	}
	/**
	 * @return the tail
	 */
	public String getTail() {
		return tail;
	}
	/**
	 * @param tail the tail to set
	 */
	public void setTail(String tail) {
		this.tail = tail;
	}
	
}
