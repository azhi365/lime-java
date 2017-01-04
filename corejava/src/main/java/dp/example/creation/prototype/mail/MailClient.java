/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午09:59:21
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.creation.prototype.mail;

import java.util.Random;

import org.junit.Test;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class MailClient {
	private static int MAX_COUNT = 6;
	@Test
	public void testPrototype(){
		Mail mail = new Mail(new AdvTemplete());
		mail.setTail("this is tail");
		int i = 0;
		while (i<MAX_COUNT){
			Mail cloneMail = mail.clone();
			cloneMail.setAppellation(new Random().nextInt(10) + "");
			cloneMail.setReceiver(new Random().nextInt(10) + "");
			cloneMail.sendMail();
			i++;
		}
	}

}
