/**
 * @author yzhi
 * @date 2012-1-30 上午09:56:53
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.flyweight.sign;

import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class SignClient {
	@Test
	public void testSign(){
		for (int i = 0; i < 4; i++) {
			String subject = "subject" + i;
			for (int j = 0; j < 30; j++) {
				String key = subject + "address" + j;
				SignInfoFactory.getSignInfo(key);
			}
		}
		SignInfo signInfo = SignInfoFactory.getSignInfo("subject1address1");
		System.out.println(signInfo);
	}
	@Ignore
	@Test
	public void testThreadUnsafe(){
		SignInfoMultiFactory.getSignInfo("subject1");
		SignInfoMultiFactory.getSignInfo("subject2");
		SignInfoMultiFactory.getSignInfo("subject3");
		SignInfoMultiFactory.getSignInfo("subject4");
		SignInfoMultiFactory.getSignInfo("subject5");
		SignInfo signInfo = SignInfoMultiFactory.getSignInfo("subject2");
		while(true){
			signInfo.setId("zhangsan");
			signInfo.setLocation("zhangsan");
			(new MultiThread(signInfo)).start();
			signInfo.setId("Lisi");
			signInfo.setLocation("Lisi");
			(new MultiThread(signInfo)).start();
		}
	}
	
	@Test
	public void testExtrinstic(){
		ExtrinsicState stateA = new ExtrinsicState();
		stateA.setSubject("subject1");
		stateA.setLocation("shanghai");
		SignInfoFactory.getSignInfo(stateA);
		ExtrinsicState stateB = new ExtrinsicState();
		stateB.setSubject("subject2");
		stateB.setLocation("shanghai");
		long currentTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			SignInfoFactory.getSignInfo(stateB);
		}
		long tailTime = System.currentTimeMillis();
		System.out.println("eclipsed time: " + (tailTime - currentTime) + "ms");
		
		String keyA = "subject1 shanghai";
		String keyB = "subject2 shanghai";
		SignInfoFactory.getSignInfo(keyA);
		currentTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			SignInfoFactory.getSignInfo(keyB);
		}
		tailTime = System.currentTimeMillis();
		System.out.println("eclipsed time: " + (tailTime - currentTime) + "ms");
	}
	@Test
	public void testString(){
		String str1 = "A";
		String str2 = "B";
		String str3 = "AB";
		String str4;
		str4 = str1 + str2;
		System.out.println(str3 == str4);
		str4 = (str1 + str2).intern();
		System.out.println(str3 == str4);
	}
}
