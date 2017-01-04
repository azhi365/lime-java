/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午08:48:30
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.adapter.user;

import java.util.HashMap;
import java.util.Map;

/**
 * 劳务公司的人员信息
 * @author YZhi
 * @since 1.0
 */
public class OuterUser implements IOuterUser {

	/* (non-Javadoc)
	 * @see structure.adapter.example.user.IOuterUser#getUserBaseInfo()
	 */
	@Override
	public Map<String, String> getUserBaseInfo() {
		HashMap<String, String> baseInfoMap = new HashMap<String, String>();
		baseInfoMap.put("userName", "the name is xxx");
		baseInfoMap.put("mobileNumber", "mobile is xxx");
		return baseInfoMap;
	}

	/* (non-Javadoc)
	 * @see structure.adapter.example.user.IOuterUser#getUserHomeInfo()
	 */
	@Override
	public Map<String, String> getUserHomeInfo() {
		HashMap<String, String> homeInfo = new HashMap<String, String>();
		homeInfo.put("homeTelNunmber", "the home tel number is xxx");
		homeInfo.put("homeAddress", "the homeAddress is xxx");
		return homeInfo;
	}
	
	public Map<String, String> getUserOfficeInfo(){
		HashMap<String, String> userOfficeInfo = new HashMap<String, String>();
		userOfficeInfo.put("jobPosition", "the job is xxx");
		userOfficeInfo.put("officeTelNumber", "the officeTelNumber is xxx");
		return userOfficeInfo;
	}

}
