/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午03:52:26
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.behaviour.memento.multi;

import java.util.HashMap;

import org.junit.Test;

/**
 * 
 * <pre>
 * 
 * 一、定义
 *     多状态的备忘录模式
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
public class MementoMultiClient {
	@Test
	public void testMementoMultiState(){
		Originator ori = new Originator();
		Caretaker caretaker = new Caretaker();
		ori.setState1("china");
		ori.setState2("strong");
		ori.setState3("big");
		System.out.println(ori);
		caretaker.setMemento(ori.createMemento());
		ori.setState1("software");
		ori.setState2("good");
		ori.setState3("very good");
		System.out.println(ori);
		ori.restoreMemento(caretaker.getMemento());
		System.out.println(ori);
	}
	@Test
	public void testMementoMultiBackup(){
		Originator originator = new Originator();
		Caretaker caretaker = new Caretaker();
		HashMap<String, Memento> hashMap = new HashMap<String, Memento>();
		hashMap.put("001", originator.createMemento());
		hashMap.put("002", originator.createMemento());
		caretaker.setMemMap(hashMap);
		originator.restoreMemento(caretaker.getMemMap().get("001"));
	}
}
