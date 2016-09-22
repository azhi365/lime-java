/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午09:05:35
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.adapter.user;

import org.junit.Test;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class UserClient {
	@Test
	public void testUser(){
		IUserInfo userInfo = new UserInfo();
		for (int i = 0; i < 101; i++) {
			userInfo.getMobileNumber();
		}
	}
	
	@Test
	public void testOuterUser(){
		IUserInfo userInfo = new OuterUserInfo();
		for (int i = 0; i < 101; i++) {
			userInfo.getMobileNumber();
		}
	}
}
