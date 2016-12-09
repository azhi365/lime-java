package org.walnuts.study.dp.behaviour.intercepreter;

import java.util.Stack;

/**
 * <pre>
 * 
 * 一、定义
 *     解析器模式(Interpreter Pattern)
 *     Given a lanugage,define a representation for its grammar along with an interpreter that users the representation to interpret sentences in the language.
 *     给定一门语言，定义它的方法的一种表示，并定义一个解析器，该解析器使用表示来解释语言中的句子。
 * 二、优点
 *     扩展性
 * 三、缺点
 *     类膨胀，每一个语法要产生一个非终结符表达式
 *     采用递归调用方法
 *     效率问题
 * 四、条件
 *     重复发生的问题
 *     一个简单语法需要解释的场景
 
 * 五、适用性
 *     
 * 六、最佳实践
 *     尽量使用shell,JRuby,Groovy等脚本代替解释器模式
 *     可以使用Expression4J、MESP(Math Exoression String Parser)、Jep等开源的解析工具包
 * </pre>
 * 
 * <img src="doc-files/interpreter.png" />
 * 
 * @author yzhi
 *
 */
public class IntercepreterClient {
	public static void main(String[] args) {
		Context context = new Context();
		Stack<Expression> stack = new Stack<Expression>();
		Expression exp = stack.pop();
		exp.interpreter(context);
	}
}
