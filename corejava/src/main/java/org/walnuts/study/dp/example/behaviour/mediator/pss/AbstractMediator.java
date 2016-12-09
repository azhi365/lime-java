/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午10:47:18
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.mediator.pss;

/**
 * 抽象中介者
 * @author YZhi
 * @since 1.0
 */
public abstract class AbstractMediator {
	protected Purchase purchase;
	protected Sale sale;
	protected Stock stock;
	public AbstractMediator(){
		purchase = new Purchase(this);
		sale = new Sale(this);
		stock = new Stock(this);
	}
	
	public abstract void execute(String str,Object...objects);
}
