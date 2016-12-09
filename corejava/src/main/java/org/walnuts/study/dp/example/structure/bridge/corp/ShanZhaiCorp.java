/**
 * 
 * @author yzhi
 * @date 2012-1-30 上午10:56:16
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.bridge.corp;

/**
 * 山寨公司
 * @author YZhi
 * @since 1.0
 */
public class ShanZhaiCorp extends Corp {

	/**
	 * 
	 * 
	 * 
	 * @param product
	 */
	public ShanZhaiCorp(Product product) {
		super(product);
	}

	/* (non-Javadoc)
	 * @see dp.example.structure.bridge.corp.Corp#makeMoney()
	 */
	@Override
	public void makeMoney() {
		super.makeMoney();
		System.out.println("shanzhai makeMoney");
	}

}
