/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午10:55:35
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.mediator.pss;

import java.util.Random;

/**
 * 销售管理
 * @author YZhi
 * @since 1.0
 */
public class Sale extends AbstractColleague {

	/**
	 * 
	 * 
	 * 
	 * @param mediator
	 */
	public Sale(AbstractMediator mediator) {
		super(mediator);
	}
	public void sellIBMComputer(int number) {
		super.mediator.execute("sale.sell", number);
		System.out.println("Sale number is" + number);
	}
	public int getSaleStatus(){
		Random random = new Random(System.currentTimeMillis());
		int saleStatus = random.nextInt(100);
		System.out.println("saleStatus is" + saleStatus);
		return saleStatus;
	}
	public void offSale(){
		super.mediator.execute("sale.offsell");
	}
}
