/**
 * @author YZhi
 * @date 2012-5-30
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.creation.factorymethod.trade;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class StrategyFactory {
	public static IDeduction getDeduction(StrategyMan strategy){
		IDeduction deduction = null;
		try {
			deduction = (IDeduction)Class.forName(strategy.getValue()).newInstance();
		} catch (Exception e) {
			
		}
		return deduction;
	}
}
