/**
 * 
 * @author YZhi
 * @date 2012-5-30
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.creation.factorymethod.trade;

/**
 * 扣款策略一
 * @author YZhi
 * @since 1.0
 */
public class StreadyDedection implements IDeduction {

	/* (non-Javadoc)
	 * @see dp.example.creation.factorymethod.trade.IDeduction#exec(dp.example.creation.factorymethod.trade.Card, dp.example.creation.factorymethod.trade.Trade)
	 */
	@Override
	public boolean exec(Card card, Trade trade) {
		int halfMoney = (int)Math.rint(trade.getAmount()/2.0);
		card.setFreeMoney(card.getFreeMoney() - halfMoney);
		card.setSteadyMoney(card.getSteadyMoney() - halfMoney);
		return true;
	}

}
