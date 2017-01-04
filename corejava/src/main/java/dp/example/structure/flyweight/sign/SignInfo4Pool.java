/**
 * 
 * @author yzhi
 * @date 2012-1-30 上午09:51:37
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.flyweight.sign;

/**
 * 带对象池的报考信息
 * @author YZhi
 * @since 1.0
 */
public class SignInfo4Pool extends SignInfo {
	private String key;

	/**
	 * 
	 * 
	 * 
	 * @param key
	 */
	public SignInfo4Pool(String key) {
		super();
		this.key = key;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
}
