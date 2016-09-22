/**
 * @author yzhi
 * @date 2012-1-29 下午03:14:15
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.memento.boy;

import org.junit.Test;
/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class BoyClient {
	@Test
	public void testBoy(){
		Boy boy = new Boy();
		Caretaker caretaker = new Caretaker();
		boy.setState("nice mood");
		System.out.println(boy.getState());
		caretaker.setMemento(boy.createMemento());
		boy.changeState();
		System.out.println(boy.getState());
		boy.restoreMemento(caretaker.getMemento());
		System.out.println(boy.getState());
	}
}
