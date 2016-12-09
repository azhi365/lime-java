/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午10:56:59
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.mediator.pss;

/**
 * 库存管理
 * @author YZhi
 * @since 1.0
 */
public class Stock extends AbstractColleague {
	/**
	 * 
	 * 
	 * 
	 * @param mediator
	 */
	public Stock(AbstractMediator mediator){
		super(mediator);
	}
	
	private static int COMPUTER_NUBMER = 100;
	public void increase(int number){
		COMPUTER_NUBMER = COMPUTER_NUBMER + number;
		System.out.println("stock number is " + COMPUTER_NUBMER);
	}
	public void decrease(int number){
		COMPUTER_NUBMER = COMPUTER_NUBMER - number;
		System.out.println("stock number is " + COMPUTER_NUBMER);
	}
	public int getStockNumber(){
		return COMPUTER_NUBMER;
	}
	
	public void clearStock(){
		System.out.println("stock number is " + COMPUTER_NUBMER);
		super.mediator.execute("stock.clear");
	}
	
}
