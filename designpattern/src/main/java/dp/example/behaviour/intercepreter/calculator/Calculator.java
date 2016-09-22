/**
 * @author yzhi
 * @date 2012-1-30 上午09:12:52
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.intercepreter.calculator;

import java.util.HashMap;
import java.util.Stack;

/**
 * 解析器封装类
 * @author YZhi
 * @since 1.0
 */
public class Calculator {
	private Expression expression;
	public Calculator(String expStr){
		Stack<Expression> stack = new Stack<Expression>();
		char[] charArray = expStr.toCharArray();
		Expression left = null;
		Expression right = null;
		for (int i = 0; i < charArray.length; i++) {
			switch (charArray[i]) {
				case '+' :
					left = stack.pop();
					right = new VarExpression(String.valueOf(charArray[++i]));
					stack.push(new AddExpression(left, right));
					break;
				case '-' :
					left = stack.pop();
					right = new VarExpression(String.valueOf(charArray[++i]));
					stack.push(new SubExpression(left, right));
					break;
				default :
					stack.push(new VarExpression(String.valueOf(charArray[i])));
					break;
			}
		}
		this.expression = stack.pop();
	}
	public int run(HashMap<String, Integer> var){
		return this.expression.interpreter(var);
	}
}
