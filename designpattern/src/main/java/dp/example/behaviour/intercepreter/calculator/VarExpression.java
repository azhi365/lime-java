/**
 * @author yzhi
 * @date 2012-1-30 上午09:04:12
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.intercepreter.calculator;

import java.util.HashMap;

/**
 * 变量解析器
 * @author YZhi
 * @since 1.0
 */
public class VarExpression extends Expression {
	private String key;
	
	/**
	 * 
	 * 
	 * 
	 * @param key
	 */
	public VarExpression(String key) {
		this.key = key;
	}


	/* (non-Javadoc)
	 * @see behaviour.intercepreter.example.calculator.Expression#interpreter(java.util.HashMap)
	 */
	@Override
	public int interpreter(HashMap<String, Integer> var) {
		return var.get(this.key);
	}

}
