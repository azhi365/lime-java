/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午09:22:12
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
public class OuterUserBaseInfo implements IOuterUserBaseInfo {

	/* (non-Javadoc)
	 * @see structure.adapter.example.userbyobjectadapter.IOuterUserBaseInfo#getUserBaseInfo()
	 */
	@Override
	public Map<String, String> getUserBaseInfo() {
		HashMap<String, String> baseInfoMap = new HashMap<String, String>();
		baseInfoMap.put("userName", "the userName is xxx");
		baseInfoMap.put("mobileNumber", "the mobile number is xxx");
		return baseInfoMap;
	}

}
