/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午09:31:04
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.adapter.userbyobjectadapter;

import java.util.Map;

import dp.example.structure.adapter.user.IUserInfo;


/**
 * 
 * @author yzhi
 * @date 2012-1-29
 * @version 
 */
public class OuterUserInfo implements IUserInfo {
	private IOuterUserBaseInfo baseInfo = null;
	private IOuterUserHomeInfo homeInfo = null;
	private IOuterUserOfficeInfo officeInfo = null;
	private Map<String, String> baseMap = null;
	private Map<String, String> homeMap = null;
	private Map<String, String> officeMap = null;
	

	/**
	 * 
	 * 
	 * 
	 * @param baseInfo
	 * @param homeInfo
	 * @param officeInfo
	 */
	public OuterUserInfo(IOuterUserBaseInfo baseInfo,
			IOuterUserHomeInfo homeInfo, IOuterUserOfficeInfo officeInfo) {
		this.baseInfo = baseInfo;
		this.homeInfo = homeInfo;
		this.officeInfo = officeInfo;
		this.baseMap = this.baseInfo.getUserBaseInfo();
		this.homeMap = this.homeInfo.getUserHomeInfo();
		this.officeMap = this.officeInfo.getUserOfficeInfo();
	}

	/* (non-Javadoc)
	 * @see structure.adapter.example.user.IUserInfo#getHomeAddress()
	 */
	@Override
	public String getHomeAddress() {
		String homeAddress = this.homeMap.get("homeAddress");
		System.out.println(homeAddress);
		return homeAddress;
	}

	/* (non-Javadoc)
	 * @see structure.adapter.example.user.IUserInfo#getHomeTelNumber()
	 */
	@Override
	public String getHomeTelNumber() {
		String homeTelNumber = this.homeMap.get("homeTelNumber");
		System.out.println(homeTelNumber);
		return homeTelNumber;
	}

	/* (non-Javadoc)
	 * @see structure.adapter.example.user.IUserInfo#getJobPosition()
	 */
	@Override
	public String getJobPosition() {
		String jobPosition = this.officeMap.get("jobPosition");
		System.out.println(jobPosition);
		return jobPosition;
	}

	/* (non-Javadoc)
	 * @see structure.adapter.example.user.IUserInfo#getMobileNumber()
	 */
	@Override
	public String getMobileNumber() {
		String mobileNumber = this.baseMap.get("mobileNumber");
		System.out.println(mobileNumber);
		return mobileNumber;
	}

	/* (non-Javadoc)
	 * @see structure.adapter.example.user.IUserInfo#getOfficeTelNumber()
	 */
	@Override
	public String getOfficeTelNumber() {
		String officeTelNumber = this.officeMap.get("officeTelNumber");
		System.out.println(officeTelNumber);
		return officeTelNumber;
	}

	/* (non-Javadoc)
	 * @see structure.adapter.example.user.IUserInfo#getUserName()
	 */
	@Override
	public String getUserName() {
		String userName = this.baseMap.get("userName");
		System.out.println(userName);
		return userName;
	}

}
