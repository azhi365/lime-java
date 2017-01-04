/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.structure.bridge.mail;

import dp.example.behaviour.strategy.mail.MailTemplate;

/**
 * SendMail邮件服务器
 * @author YZhi
 * @since 1.0
 */
public class SendMail extends MailServer {

	/**
	 * 
	 * 
	 * 
	 * @param mail
	 */
	public SendMail(MailTemplate mail) {
		super(mail);
	}
	
	/* (non-Javadoc)
	 * @see dp.example.structure.bridge.mail.MailServer#sendMail()
	 */
	@Override
	public void sendMail() {
		super.mail.add("sendmail context");
		super.sendMail();
	}
}
