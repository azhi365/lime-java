/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午11:25:32
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.behaviour.observer;

import org.junit.Test;

/**
 * 
 * <pre>
 * 
 * 一、定义
 *     观察者模式(Observer Pattern) 也称发布订阅模式(Publish/subscribe)
 *     1、Define a one-to-many dependency between objects so that when one objects changes state,
 *     all its dependents are notified and updated automatically.
 *     定义对象间一种一对多的依赖关系，使得每当一个对象 改变状态，则所有依赖于它的对象都会得到通知并被自动更新
 *     
 * 二、优点
 *     观察者和被观察者之间是抽象耦合
 *     建立一套触发机制
 * 三、缺点
 *     开发效率和运行效率的问题
 * 四、条件
 *     
 * 五、适用性
 *     广播链的问题、异步处理问题
 *     观察者与被观察者之间的消息沟通：在参数中传递DTO
 *     观察者的响应方式：多线程和缓存技术
 *     被观察者尽量自己做主
 * 六、最佳实践
 *     文件系统、猫鼠游戏、ATM取钱、广播收音机
 * </pre>
 * <img src="doc-files/observer.png" />
 * @author yzhi
 */
public class ObserverClient {
	@Test
	public void testObserver(){
		ConcreteSubject subject = new ConcreteSubject();
		Observer obs = new ConcreteObserver();
		subject.addObserver(obs);
		subject.doSomething();
	}
}
