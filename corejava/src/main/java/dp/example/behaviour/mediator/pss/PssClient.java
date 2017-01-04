/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午11:13:48
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.mediator.pss;

import org.junit.Test;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class PssClient {
	@Test
	public void testPss(){
		AbstractMediator mediator = new Mediator();
		Purchase purchase = new Purchase(mediator);
		purchase.buyIBMcomputer(100);
		Sale sale = new Sale(mediator);
		sale.sellIBMComputer(1);
		Stock stock = new Stock(mediator);
		stock.clearStock();
	}
	
}
