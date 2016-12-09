/**
 * 
 * @author yzhi
 * @date 2012-1-30 上午09:10:12
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.intercepreter.calculator;

import java.util.HashMap;

/**
 * 减法解析器
 * @author YZhi
 * @since 1.0
 */
public class SubExpression extends SymbolExpression {
	

	/**
	 * 
	 * 
	 * 
	 * @param left
	 * @param right
	 */
	public SubExpression(Expression left, Expression right) {
		super(left, right);
	}

	/* (non-Javadoc)
	 * @see behaviour.intercepreter.example.calculator.Expression#interpreter(java.util.HashMap)
	 */
	@Override
	public int interpreter(HashMap<String, Integer> var) {
		return super.left.interpreter(var) - super.right.interpreter(var);
	}

}
