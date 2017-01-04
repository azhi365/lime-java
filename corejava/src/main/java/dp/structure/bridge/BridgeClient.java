package dp.structure.bridge;

import org.junit.Test;

/**
 * 
/**
 * <pre>
 * 
 * 一、定义
 *    桥梁模式(Bridge Pattern) 也称桥接模式
 *    1、Decouple an abstraction from its implementation so that the two can vary independently.
 *    将抽象和实现解耦，使两者可以独立地变化。
 * 二、优点
 *     抽象和实现分离
 *     优秀的扩充能力
 *     实现细节对客户透明
 * 三、缺点
 *     
 * 四、条件
 *     
 * 五、适用性
 *     不希望或不适合使用继承的场景
 *     接口或抽象类不稳定的场景t
 *     征用性要求较高的场景
 * 六、最佳实践
 *     
 * </pre>
 * 
 * <img src="doc-files/bridge.png" />
 * @author yzhi
 */
public class BridgeClient {
	@Test
	public void testBridge(){
		Abstraction abstraction = new RefinedAbstraction(new ConcreteImplementorA());
		abstraction.methodC();
		
		Abstraction abstraction2 = new RefinedAbstraction(new ConcreteImplementorB());
		abstraction2.methodC();
	}
}
