/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午10:59:13
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.mediator.pss;

/**
 * 具体中介者
 * @author YZhi
 * @since 1.0
 */
public class Mediator extends AbstractMediator {

	/* (non-Javadoc)
	 * @see behaviour.mediator.example.pss.AbstractMediator#execute(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void execute(String str, Object... objects) {
		if(str.equals("pruchase.buy")){
			this.buyComputer((Integer)objects[0]);
		}else if(str.equals("sale.sell")) {
			 this.sellComputer((Integer)objects[0]);
		}else if(str.equals("sale.offsell")){
			this.offSell();
		}else if(str.equals("stock.clear")) {
			this.clearStock();
		}
	}
	
	private void clearStock() {
		super.sale.offSale();
		super.purchase.refuseBuyIBM();
	}
	private void offSell() {
		System.out.println("offsell" + stock.getStockNumber());
	}
	private void buyComputer(int number){
		int saleStatus = super.sale.getSaleStatus();
		if(saleStatus > 80){
			System.out.println("pruchase IBM" + number);
			super.stock.increase(number);
		}else {
			int buyNumber = number/2;
			System.out.println("purchase IBM" + buyNumber);
			super.stock.increase(buyNumber);
		}
	}
	
	private void sellComputer(int number){
		if(super.stock.getStockNumber() < number){
			super.purchase.buyIBMcomputer(number);
		}
		super.stock.decrease(number);
	}
	
	
}
