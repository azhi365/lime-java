package dp.behaviour.memento;

import org.junit.Test;

/**
 * <pre>
 * 
 * 一、定义
 *     备忘录模式(Memento Pattern)
 *     Without violating encapsulation,capture and externalize an object`s internal state so that the object can be restored to this state later.
 *     在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态。
 *     
 * 二、优点
 *     
 * 三、缺点
 *     
 * 四、条件
 *     
 * 五、适用性
 *     需要保存和恢复数据的相关状态场景
 *     需要监控的副本场景
 * 六、最佳实践
 *     备忘录的生命期
 *     备忘录的性能
 * </pre>
 * 
 * <img src="doc-files/memento.png" />
 * @author yzhi
 *
 */
public class MemontoClient {
	@Test
	public void testMemnto(){
		Originator originator = new Originator();
		Caretaker caretaker = new Caretaker();
		caretaker.setMemento(originator.createMemento());
		originator.restoreMemento(caretaker.getMemento());	
	}
}
