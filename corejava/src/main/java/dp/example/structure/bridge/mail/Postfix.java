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
 * 
 * @author YZhi
 * @since 1.0
 */
public class Postfix extends MailServer {

	/**
	 * 
	 * 
	 * 
	 * @param mail
	 */
	public Postfix(MailTemplate mail) {
		super(mail);
	}
	/* (non-Javadoc)
	 * @see dp.example.structure.bridge.mail.MailServer#sendMail()
	 */
	@Override
	public void sendMail() {
		String context = "postfix context";
		super.mail.add(context);
		super.sendMail();
	}
}
