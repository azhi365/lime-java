/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午04:28:19
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.strategy.zhaoyun;

/**
 * 乔国老开后门
 * @author YZhi
 * @since 1.0
 */
public class BackDoor implements IStrategy {

	/* (non-Javadoc)
	 * @see behaviour.strategy.example.zhaoyun.IStrategy#operate()
	 */
	@Override
	public void operate() {
		System.out.println("back door");
	}

}
