/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.strategy.mail;

import org.junit.Test;

import org.walnuts.study.dp.example.structure.bridge.mail.Postfix;

/**
 * <pre>
 * 策略模式VS桥梁模式
 * 策略模式使用继承和多态建立一套可以自由切换算法的模式
 * 栋梁模式是在不破坏封装的前提下解决抽象和实现都可以独立扩展的模式
 * </pre>
 * @author YZhi
 * @since 1.0
 */
public class MailClient {
	/**
	 * 策略模式
	 */
	@Test
	public void testMailStrategy(){
		MailTemplate html= new HtmlMail("from", "to", "subject", "context");
		MailTemplate text = new TextMail("from", "to", "subject", "context");
		MailServer server = new MailServer(html);
		server.sendMail();
		server = new MailServer(text);
		server.sendMail();
	}
	/**
	 * 桥梁模式
	 */
	@Test
	public void testMailBridge(){
		MailTemplate mail = new HtmlMail("from", "to", "subject", "context");
		org.walnuts.study.dp.example.structure.bridge.mail.MailServer mailServer = new Postfix(mail);
		mailServer.sendMail();
	}
}
