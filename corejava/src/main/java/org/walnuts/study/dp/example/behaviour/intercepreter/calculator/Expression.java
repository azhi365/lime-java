/**
 * @author yzhi
 * @date 2012-1-30 上午09:02:50
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.intercepreter.calculator;

import java.util.HashMap;

/**
 * 抽象表达式
 * @author YZhi
 * @since 1.0
 */
public abstract class Expression {
	public abstract int interpreter(HashMap<String, Integer> var);
}
