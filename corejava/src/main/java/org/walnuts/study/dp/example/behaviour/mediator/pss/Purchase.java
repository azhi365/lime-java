/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午10:51:26
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.mediator.pss;

/**
 * 采购管理
 * @author YZhi
 * @since 1.0
 */
public class Purchase extends AbstractColleague {

	/**
	 * 
	 * 
	 * 
	 * @param mediator
	 */
	public Purchase(AbstractMediator mediator) {
		super(mediator);
	}
	public void buyIBMcomputer(int number) {
		super.mediator.execute("purchase.buy", number);
	}
	public void refuseBuyIBM(){
		System.out.println("refuse buy IBM");
	}
}
