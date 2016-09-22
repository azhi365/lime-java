/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午10:11:01
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.creation.prototype;
/**
 * 简单的可拷贝对象
 * @author YZhi
 * @since 1.0
 */
public class Thing implements Cloneable {
	public Thing(){
		System.out.println("constructor is executed");
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Thing clone(){
		Thing thing = null;
		try {
			thing = (Thing)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return thing;
	}	
}
