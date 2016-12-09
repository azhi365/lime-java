package org.walnuts.study.dp.behaviour.mediator;

/**
 * <pre>
 * 
 * 一、定义
 *     中介者模式
 *     1、Define an object that encapsulates how a set of objects interact.
 *     Mediator promotes loose coupling by keeping objects from referring to each other explicitly,
 *     and it lets you vary their interaction independently.
 *     用一个中介对象封装一系列的对象交互，中介者使各对象不需要显式地相互作用，从而使其耦合松散，而且可以独立地改变它们之间的交互
 * 二、优点
 *     减少类间依赖，把一对多的依赖变成一对一
 * 三、缺点
 *     中介者膨胀，中介者逻辑复杂
 * 四、条件
 *     
 * 五、适用性
 *     网状依赖，多个对象相互依赖
 * 六、最佳实践
 *     机场调度中心、MVC框架、媒体网关、中介服务
 * </pre>
 * 
 * <img src="doc-files/mediator.png" />
 * @author yzhi
 *
 */
public class MediatorClient {
	public static void main(String[] args) {
		Mediator mediator = new ConcreteMediator();
		ConcreteColleagueA cA = new ConcreteColleagueA(mediator);
		ConcreteColleagueB cB = new ConcreteColleagueB(mediator);
		cA.depMethod();
		cA.selfMethod();
		cB.depMethod();
		cB.selfMehtod();
	}
}
