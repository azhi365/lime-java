package dp.structure.facade;

import org.junit.Test;

/**
 * 
 * <pre>
 * 
 * 一、定义
 *     门面模式(Facade Pattern) 也称外观模式
 *     Provide a unified interface to a set of interfaces in a subsystem.
 *     Facade defines a higher-level interface that makes the subsystem easier to use.
 *     要求一个子系统的外部与其内部的通信必须通过一个统一的对象进行。门模式提供一个高层次的接口，使得子系统更易于使用。
 *     一个子系统可以有多个门面
 * 二、优点
 *     减少系统的相互依赖
 *     提高了灵活性
 *     提高安全性
 * 三、缺点
 *     不符合开闭原则
 * 四、条件
 *     
 * 五、适用性
 *     为一个复杂的模块或子系统提供一个供外界访问的接口
 *     子系统相对独立
 *     预防低水平人员带来的风险扩散
 * 六、最佳实践
 *     
 * </pre>
 * 
 * <img src="doc-files/facade.png" />
 * @author yzhi
 *
 */
public class FacadeClient {
	@Test
	public void testFacade(){
		Facade facade = new Facade();
		facade.operate();
		
		facade.MethodA();
		facade.MethodB();
		facade.MethodC();
	}
}
