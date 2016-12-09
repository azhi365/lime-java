/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午09:23:56
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
public class OuterUserHomeInfo implements IOuterUserHomeInfo {

	/* (non-Javadoc)
	 * @see structure.adapter.example.userbyobjectadapter.IOuterUserHomeInfo#getUserHomeInfo()
	 */
	@Override
	public Map<String, String> getUserHomeInfo() {
		Map<String, String> userHomeInfo = new HashMap<String, String>();
		userHomeInfo.put("homeTelNumber", "the home TelNumber is xxx");
		userHomeInfo.put("homeAddress", "the home address is xxx");
		return userHomeInfo;
	}

}
