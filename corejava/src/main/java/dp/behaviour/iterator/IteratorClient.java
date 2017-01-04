/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午10:21:16
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.behaviour.iterator;

import org.junit.Test;

/**
 * 
 * <pre>
 * 
 * 一、定义
 *     迭代器模式(Iterator Pattern)
 *     1、Provide a way to access the elements of an aggregate object sequetially without exposing its underlying representation.
 *     它提供一种方法访问一个窗口对象中各个元素，而又不需暴露该对旬的内部细节
 * 二、优点
 *     
 * 三、缺点
 *     
 * 四、条件
 *     
 * 五、适用性
 *     
 * 六、最佳实践
 *     java.util.Iterable接口
 * </pre>
 * 
 * <img src="doc-files/iterator.png" />
 * @author yzhi
 */
public class IteratorClient {
	@Test
	public void testIterator(){
		Aggregate aggregate = new ConcreteAggregate();
		aggregate.add(new ConcreteAggregate());
		aggregate.add(new ConcreteAggregate());
		aggregate.add(new ConcreteAggregate());
		Iterator<Aggregate> iterator = aggregate.iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
