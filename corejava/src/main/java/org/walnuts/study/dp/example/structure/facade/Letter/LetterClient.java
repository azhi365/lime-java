/**
 * @author yzhi
 * @date 2012-1-29 下午03:00:36
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.facade.Letter;

import org.junit.Test;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class LetterClient {
	@Test
	public void testLetter(){
		ModenPostOffice postOffice = new ModenPostOffice();
		postOffice.sendLetter("the context", "the address");
	}
}
