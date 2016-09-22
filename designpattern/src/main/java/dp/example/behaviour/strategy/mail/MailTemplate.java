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
 * 抽象邮件
 * 没有抽象方法的抽象类，主要是为了不让实例化
 * @author YZhi
 * @since 1.0
 */
public abstract class MailTemplate {
	private String from;
	private String to;
	private String subject;
	private String context;
	/**
	 * 
	 * 
	 * 
	 * @param from
	 * @param to
	 * @param subject
	 * @param context
	 */
	public MailTemplate(String from, String to, String subject, String context) {
		super();
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.context = context;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	public void add(String context){
		this.context = context + this.context;
	}
	
}
