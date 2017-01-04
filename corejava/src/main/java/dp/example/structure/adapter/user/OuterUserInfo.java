/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午08:57:15
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.adapter.user;

import java.util.Map;

/**
 * 中转角色
 * @author YZhi
 * @since 1.0
 */
public class OuterUserInfo extends OuterUser implements IUserInfo {
	private Map<String, String> baseInfo = super.getUserBaseInfo();
	private Map<String, String> homeInfo = super.getUserHomeInfo();
	private Map<String, String> officeInfo = super.getUserOfficeInfo();
	/* (non-Javadoc)
	 * @see structure.adapter.example.user.IUserInfo#getHomeAddress()
	 */
	@Override
	public String getHomeAddress() {
		String homeAddres = this.homeInfo.get("homeAddress");
		System.out.println(homeAddres);
		return homeAddres;
	}

	/* (non-Javadoc)
	 * @see structure.adapter.example.user.IUserInfo#getHomeTelNumber()
	 */
	@Override
	public String getHomeTelNumber() {
		String homeTelNumber = this.homeInfo.get("homeTelNumber");
		System.out.println(homeTelNumber);
		return homeTelNumber;
	}

	/* (non-Javadoc)
	 * @see structure.adapter.example.user.IUserInfo#getJobPosition()
	 */
	@Override
	public String getJobPosition() {
		String jobPosition = this.officeInfo.get("jobPosition");
		System.out.println(jobPosition);
		return jobPosition;
	}

	/* (non-Javadoc)
	 * @see structure.adapter.example.user.IUserInfo#getMobileNumber()
	 */
	@Override
	public String getMobileNumber() {
		String mobilePosition = this.baseInfo.get("mobileNumber");
		System.out.println(mobilePosition);
		return mobilePosition;
	}

	/* (non-Javadoc)
	 * @see structure.adapter.example.user.IUserInfo#getOfficeTelNumber()
	 */
	@Override
	public String getOfficeTelNumber() {
		String officeTelNumber = this.officeInfo.get("officeTelNumber");
		System.out.println(officeTelNumber);
		return officeTelNumber;
	}

	/* (non-Javadoc)
	 * @see structure.adapter.example.user.IUserInfo#getUserName()
	 */
	@Override
	public String getUserName() {
		String userName = this.baseInfo.get("userName");
		System.out.println(userName);
		return userName;
	}

}
