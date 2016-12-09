/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午09:27:48
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.adapter.userbyobjectadapter;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author yzhi
 * @date 2012-1-29
 * @version 
 */
public class OuterUserOfficeInfo implements IOuterUserOfficeInfo {

	/* (non-Javadoc)
	 * @see structure.adapter.example.userbyobjectadapter.IOuterUserOfficeInfo#getUserOfficeInfo()
	 */
	@Override
	public Map<String, String> getUserOfficeInfo() {
		Map<String, String> userOfficeInfo = new HashMap<String, String>();
		userOfficeInfo.put("jobPosition", "the job position is xxx");
		userOfficeInfo.put("officeNumber", "the office telephone is xxx");
		return userOfficeInfo;
	}

}
