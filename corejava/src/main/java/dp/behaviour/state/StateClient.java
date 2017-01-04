package dp.behaviour.state;

import org.junit.Test;

/**
 * <pre>
 * 
 * 一、定义
 *     状态模式
 *     Allow an object to alter its behavior when its internal state changes.
 *     The object will appear to change to class
 *     当一个对象内在状态改变时允许其改变行为，这个对象看起来像改变了其类。
 * 二、优点
 *     结构清晰
 *     遵循设计原则
 *     封装性非常好
 * 三、缺点
 *     子类膨胀
 * 四、条件
 *     
 * 五、适用性
 *     行为随状态改变而改变的场景
 *     条件、分支判断语句的替代者
 * 六、最佳实践
 *     
 * </pre>
 * 
 * <img src="doc-files/state.png" />
 * @author yzhi
 *
 */
public class StateClient {

	@Test
	public void testSate(){
		Context context = new Context();
		context.setCurrentState(new ConcreteStateA());
		context.handleA();
		context.setCurrentState(new ConcreteStateB());
		context.handleA();
	}
}
