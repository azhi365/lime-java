/**
 * 
 * @author YZhi
 * @date 2012-5-30
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.factorymethod.trade;

/**
 * 扣款模块封装
 * @author YZhi
 * @since 1.0
 */
public class DeductionFacade {
	public static Card deduct(Card card,Trade trade){
		StrategyMan reg = getDeductionType(trade);
		IDeduction deduction = StrategyFactory.getDeduction(reg);
		DedutionContext context = new DedutionContext(deduction);
		context.exec(card, trade);
		return card;
	}

	/**
	 *
	 * @param trade
	 * @return
	 */
	private static StrategyMan getDeductionType(Trade trade) {
		if(trade.getTradeNo().contains("abc")){
			return StrategyMan.FreeDeduction;
		}else {
			return StrategyMan.StreayDeduction;
		}
	}
}
