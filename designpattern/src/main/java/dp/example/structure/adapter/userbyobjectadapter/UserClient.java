/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午09:38:39
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.adapter.userbyobjectadapter;

import org.junit.Test;

import dp.example.structure.adapter.user.IUserInfo;


/**
 * 对象适配器
 * @author yzhi
 * @date 2012-1-29
 * @version 
 */
public class UserClient {
	@Test
	public void testUserByObjectAdpater(){
		IOuterUserBaseInfo baseInfo = new OuterUserBaseInfo();
		IOuterUserHomeInfo homeInfo = new OuterUserHomeInfo();
		IOuterUserOfficeInfo officeInfo = new OuterUserOfficeInfo();
		IUserInfo userInfo = new OuterUserInfo(baseInfo, homeInfo, officeInfo);
		for (int i = 0; i < 101; i++) {
			userInfo.getMobileNumber();
		}
	}
}
