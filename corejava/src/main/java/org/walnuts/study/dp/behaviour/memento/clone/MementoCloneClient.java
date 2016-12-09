/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午03:29:15
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.behaviour.memento.clone;

import org.junit.Test;

/**
 * 
 * <pre>
 * 
 * 一、定义
 *     Clone方式的备忘录
 * 二、优点
 *     
 * 三、缺点
 *     
 * 四、条件
 *     
 * 五、适用性
 *     
 * 六、最佳实践
 *     
 * </pre>
 * @author yzhi
 */
public class MementoCloneClient {
	@Test
	public void testMementoClone(){
		Originator originator = new Originator();
		originator.setState("init state");
		System.out.println(originator.getState());
		originator.createMemento();
		originator.setState("modified state");
		System.out.println(originator.getState());
		originator.restoreMemento(originator);
		System.out.println("restored state");
	}
}
