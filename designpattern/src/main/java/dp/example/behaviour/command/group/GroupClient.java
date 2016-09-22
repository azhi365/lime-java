/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午03:00:14
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.command.group;

import org.junit.Test;

/**
 * 命令模式Group例子
 * @author yzhi
 * @date 2012-1-20
 * @version 
 */
public class GroupClient {
	/**
	 *
	 */
	@Test
	public void testCommand(){
		Invoker invoker = new Invoker();
		Command command = new AddRequirementCommand();
		invoker.setCommand(command);
		invoker.action();
		command = new DeletePageCommand();
		invoker.setCommand(command);
		invoker.action();
	}
}
