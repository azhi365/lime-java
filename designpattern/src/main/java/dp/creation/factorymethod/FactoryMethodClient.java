/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午02:45:55
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.creation.factorymethod;

import org.junit.Test;

/**
 * 
 * <pre>
 * 工厂方法模式(Factory Method Pattern)
 * 一、定义
 *     1、Define an interface for creating an object,but let subclasses decide which class to instantiate.
 *     Factory Method lets a class defer instantiation to subclasses.
 *     定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到子类。
 *     2、工厂方法关注的是一个产品整体，生产出来的产品应该具有相似的功能和架构。
 *     
 * 二、优点
 *     良好的封装性，代码结构清晰
 *     扩展性非常优秀
 *     屏蔽产品类
 *     典型的解耦框架
 * 三、缺点
 *     
 * 四、条件
 *     
 * 五、适用性
 *     在所有需要生成对象的地方都可以使用
 *     可以用在异构项目中
 *     可以使用在测试驱动开发的框架下，应该使用JMock或EasyMock
 * 六、最佳实践
 *     
 * </pre>
 * 
 * <img src="doc-files/factory.png" />
 * @author yzhi
 */
public class FactoryMethodClient {
	@Test
	public void testFactoryMethod(){
		Creator creator = new ConcreteCreator();
		creator.createProduct(ConcreteProduct1.class);
	}
}
