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
 * 扣款策略封装
 * @author YZhi
 * @since 1.0
 */
public class DedutionContext {
	private IDeduction deduction = null;
	public DedutionContext(IDeduction deduction){
		this.deduction = deduction;
	}
	public boolean exec(Card card,Trade trade){
		return this.deduction.exec(card, trade);
	}
}
