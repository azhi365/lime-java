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
 * 扣款策略二
 * @author YZhi
 * @since 1.0
 */
public class FreeDeduction implements IDeduction {

	/* (non-Javadoc)
	 * @see dp.example.creation.factorymethod.trade.IDeduction#exec(dp.example.creation.factorymethod.trade.Card, dp.example.creation.factorymethod.trade.Trade)
	 */
	@Override
	public boolean exec(Card card, Trade trade) {
		card.setFreeMoney(card.getFreeMoney() - trade.getAmount());
		return false;
	}

}
