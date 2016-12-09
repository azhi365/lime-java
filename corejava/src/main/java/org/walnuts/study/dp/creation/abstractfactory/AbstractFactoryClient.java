/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午04:02:02
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.creation.abstractfactory;

import org.junit.Test;

/**
 * <pre>
 * 抽象工厂模式(Abstract Factory Pattern)
 * 一、定义
 *     1、Provide an interface fro creating families of related or dependent objects without specifying
 * their concrete classes.
 *     为创建一组相关或相互依赖的对象提供一个接口，而且无需指定它们的具体类。
 *     2、实现对产品家族的创建，具有不同分类维度的产品组合，不关心构建过程，只关心什么产品由什么工厂生产，一个工厂只生产一种
 *     固定型号
 *     
 * 二、优点
 *     封装性
 *     产品族内的约束为非公开状态
 * 三、缺点
 *     产品族扩展非常困难，横向扩展容易，纵向扩展难
 * 四、条件
 *     
 * 五、适用性
 *     一个对象族(或是一组没有任何关系的对象)都有相同的约束
 * 六、最佳实践
 *     如开发多个操作系统平台上的软件时
 * </pre>
 * 
 * <img src="doc-files/abstract.png" />
 * 
 * @author yzhi
 * @date 2012-1-19
 * @version 
 */
public class AbstractFactoryClient {
	@Test
	public void testAbstractFactory(){
		AbstractCreator creator1 = new Creator1();
		AbstractCreator creator2 = new Creator2();
		AbstractProductA a1 = creator1.createProductA();
		AbstractProductA a2 = creator2.createProductA();
		AbstractProductB b1 = creator1.createProductB();
		AbstractProductB b2 = creator2.createProductB();
		a1.doSomething();
		a2.doSomething();
		b1.doSomething();
		b2.doSomething();
	}
}
