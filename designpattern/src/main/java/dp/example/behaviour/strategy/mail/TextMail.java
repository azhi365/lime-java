/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.behaviour.strategy.mail;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class TextMail extends MailTemplate {

	/**
	 * 
	 * 
	 * 
	 * @param from
	 * @param to
	 * @param subject
	 * @param context
	 */
	public TextMail(String from, String to, String subject, String context) {
		super(from, to, subject, context);
	}
	
	/* (non-Javadoc)
	 * @see dp.example.behaviour.strategy.mail.MailTemplate#getContext()
	 */
	@Override
	public String getContext() {
		return "text";
	}
	
}
