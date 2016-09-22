package dp.behaviour.templete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * <pre>
 * 模板方法模式(Template Method Pattern)
 * 一、定义
 *     1、Define the skeleton of an algorithm in an operation,deferring some steps to subclasses.
 *     Template Method lets subclasses redefine certain steps of an algorithm without changing the algoritm`s structure.
 *     定义一个操作中的算法的框架，而将一些步骤延迟到中，使得可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
 * 二、优点
 *     1、封装不变部分、扩展可变部门
 *     2、提取公共部门代码，便于维护
 *     3、行为由父类控制、子类实现
 * 三、缺点
 *     抽象类定义了部分抽象方法，由子类实现，子类执行的结果影响了父类的结果
 * 四、条件
 *     
 * 五、适用性
 *     1、多个子类有公有的方法，并且逻辑基本相同时。
 *     2、重要、复杂的算法可设计为模板方法
 *     3、重构时，把相同的代码抽象戩父类中，通过钩子函数约束其行为
 * 六、最佳实践
 *     1、抽象模板类中的方法尽量设计为protected
 * </pre>
 * 
 * <img src="doc-files/template.png" />
 * @author yzhi
 *
 */
public class TempleteClient {
	public static void main(String[] args) throws IOException {
		String flag = (new BufferedReader(new InputStreamReader(System.in))).readLine();
		ConcreteClassA concreteClassA = new ConcreteClassA();
		ConcreteClassB concreteClassB = new ConcreteClassB();
		concreteClassA.templeteMethod();
		if(flag.equals("0")){
			concreteClassB.setFlag(false);
		}
		concreteClassB.templeteMethod();
	}
}
