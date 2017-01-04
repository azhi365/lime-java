/**
 * 
 * @author yzhi
 * @date 2012-1-30 上午09:51:01
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.flyweight.sign;

import java.util.HashMap;
/**
 * 报考工厂
 * @author YZhi
 * @since 1.0
 */
public class SignInfoFactory {
	private static HashMap<String, SignInfo> pool = new HashMap<String, SignInfo>();
	private static HashMap<ExtrinsicState, SignInfo> poolWithExtrinsic = new HashMap<ExtrinsicState, SignInfo>();
	public static SignInfo getSignInfo(){
		return new SignInfo();
	}
	public static SignInfo getSignInfo(String key){
		SignInfo signInfo = null;
		if(!pool.containsKey(key)){
			//System.out.println(key + "created");
			signInfo = new SignInfo4Pool(key);
			pool.put(key, signInfo);
		}else {
			signInfo = pool.get(key);
			//System.out.println(key + " from pool");
		}
		return signInfo;
	}
	public static SignInfo getSignInfo(ExtrinsicState key){
		SignInfo signInfo = null;
		if(!pool.containsKey(key)){
			signInfo = new SignInfo();
			poolWithExtrinsic.put(key, signInfo);
		}else {
			signInfo = poolWithExtrinsic.get(key);
		}
		return signInfo;
	}
}
