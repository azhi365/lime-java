/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午04:28:46
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.strategy.zhaoyun;

/**
 * 吴国太开绿灯
 * @author YZhi
 * @since 1.0
 */
public class GreenLight implements IStrategy {

	/* (non-Javadoc)
	 * @see behaviour.strategy.example.zhaoyun.IStrategy#operate()
	 */
	@Override
	public void operate() {
		System.out.println("green light");
	}

}
