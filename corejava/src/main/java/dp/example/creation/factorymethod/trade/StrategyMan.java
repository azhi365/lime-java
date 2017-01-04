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
 * 策略枚举
 * @author YZhi
 * @since 1.0
 */
public enum StrategyMan {
	StreayDeduction("dp.example.creation.factorymethod.trade.StreadyDedection"),
	FreeDeduction("dp.example.creation.factorymethod.trade.FreeDedection");
	String value = "";
	
	public String getValue() {
		return value;
	}
	/**
	 * 
	 * @param value
	 */
	private StrategyMan(String value) {
		this.value = value;
	}
}
