/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.strategy.mail;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class MailServer {
	private MailTemplate mail;

	/**
	 * 
	 * 
	 * 
	 * @param mail
	 */
	public MailServer(MailTemplate mail) {
		this.mail = mail;
	}
	
	public void sendMail(){
		System.out.println(mail.getFrom());
		System.out.println(mail.getTo());
		System.out.println(mail.getSubject());
		System.out.println(mail.getContext());
	}
}
