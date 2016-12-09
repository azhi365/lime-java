/**
 * @author yzhi
 * @date 2012-1-30 上午10:10:03
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.flyweight.sign;

import java.util.HashMap;

/**
 * 多线程享元工厂
 * @author YZhi
 * @since 1.0
 */
public class SignInfoMultiFactory {
	private static HashMap<String, SignInfo> pool = new HashMap<String, SignInfo>();
	public static SignInfo getSignInfo(String key){
		SignInfo signInfo = null;
		if(!pool.containsKey(key)){
			signInfo = new SignInfo();
			pool.put(key, signInfo);
		}else {
			signInfo = pool.get(key);
		}
		return signInfo;
	}
}
