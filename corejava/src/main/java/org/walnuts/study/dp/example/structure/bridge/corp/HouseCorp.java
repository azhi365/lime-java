/**
 * @author yzhi
 * @date 2012-1-30 上午10:41:30
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.bridge.corp;

/**
 * 地产公司
 * @author YZhi
 * @since 1.0
 */
public class HouseCorp extends Corp {
	public HouseCorp(House house){
		super(house);
	}
	
	/* (non-Javadoc)
	 * @see dp.example.structure.bridge.corp.Corp#makeMoney()
	 */
	@Override
	public void makeMoney() {
		super.makeMoney();
		System.out.println("house corp makemoney");
	}

}
