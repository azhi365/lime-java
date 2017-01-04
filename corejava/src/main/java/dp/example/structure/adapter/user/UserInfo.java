/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午05:14:04
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.adapter.user;

/**
 * 员工信息实现
 * @author YZhi
 * @since 1.0
 */
public class UserInfo implements IUserInfo {

	/* (non-Javadoc)
	 * @see structure.adapter.example.user.IUserInfo#getHomeAddress()
	 */
	@Override
	public String getHomeAddress() {
		System.out.println("home address");
		return null;
	}

	/* (non-Javadoc)
	 * @see structure.adapter.example.user.IUserInfo#getHomeTelNumber()
	 */
	@Override
	public String getHomeTelNumber() {
		System.out.println("home TelNumber");
		return null;
	}

	/* (non-Javadoc)
	 * @see structure.adapter.example.user.IUserInfo#getJobPosition()
	 */
	@Override
	public String getJobPosition() {
		System.out.println("the job is boss");
		return null;
	}

	/* (non-Javadoc)
	 * @see structure.adapter.example.user.IUserInfo#getMobileNumber()
	 */
	@Override
	public String getMobileNumber() {
		System.out.println("mobile is 0000");
		return null;
	}

	/* (non-Javadoc)
	 * @see structure.adapter.example.user.IUserInfo#getOfficeTelNumber()
	 */
	@Override
	public String getOfficeTelNumber() {
		System.out.println("office telphone is 1111");
		return null;
	}

	/* (non-Javadoc)
	 * @see structure.adapter.example.user.IUserInfo#getUserName()
	 */
	@Override
	public String getUserName() {
		System.out.println("name is xxx");
		return null;
	}

}
