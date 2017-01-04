/**
 * 
 * @author yzhi
 * @date 2012-1-30 上午09:05:42
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.intercepreter.calculator;

/**
 * 抽象运算符号解析器
 * @author YZhi
 * @since 1.0
 */
public abstract class SymbolExpression extends Expression {
	protected Expression left;
	protected Expression right;

	/**
	 * 
	 * 
	 * 
	 * @param left
	 * @param right
	 */
	public SymbolExpression(Expression left, Expression right) {
		super();
		this.left = left;
		this.right = right;
	}
}
