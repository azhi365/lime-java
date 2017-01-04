package dp.structure.decorator;

import org.junit.Test;


/**
 * 
 * <pre>
 * 
 * 一、定义
 *     装饰模式(Decorator Pattern)
 *     1、Attach additional responsibilites to an object dynamically keeping the same interface.
 *     Decorators provide a flexiable alternative to subclassing for extending functionality.
 *     动态地给一个对象添加一些额外的职责，就增加功能 来说，装饰模式相比生成 子类更为灵活。
 * 二、优点
 *     装饰类和被装饰类可以独立发展
 *     装饰模式是继承关系的一个替代方案
 *     装饰模式可以动态地扩展一个实现类的功能
 * 三、缺点
 *     多层装饰比较复杂
 * 四、条件
 *     
 * 五、适用性
 *     
 * 六、最佳实践
 *     
 * </pre>
 * 
 * <img src="doc-files/decorator.png" />
 * @author yzhi
 *
 */
public class DecoratorClient {
	@Test
	public void testDecorator() {
		Component component = new ConcreteComponent();
		component = new ConcreteDecoratorA(component);
		component = new ConcreteDecoratorB(component);
		component.operate();
	}
}
