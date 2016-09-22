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
 * 扣款策略接口
 * @author YZhi
 * @since 1.0
 */
public interface IDeduction {
	public boolean exec(Card card,Trade trade);
}
