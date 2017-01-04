/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午11:33:57
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.behaviour.command;

import org.junit.Test;

/**
 * 
 * <pre>
 * 
 * 一、定义
 *     命令模式
 *     1、Encapsualte a request as an object,thereby letting you parameterize client with different requests,
 *     queue or log requests,and support undoable operations.
 *     将一个请求封装成一个对象，从而使你使用不同的请求把客户端参数化，对请求排队或者记录请求日志，可以提供命令撤销和恢复功能
 * 二、优点
 *     类间解耦、可扩展性、结合模板方法可以减少Command子类膨胀问题
 * 三、缺点
 *     N个命令有N个Command子类，子类膨胀大
 * 四、条件
 *     认为是命令的地方
 * 五、适用性
 *     
 * 六、最佳实践
 *     
 * </pre>
 * 
 * <img src="doc-files/command.png" />
 * @author yzhi
 * @since 1.0
 */
public class CommandClient {
	/**
	 *命令模式
	 */
	@Test
	public void testCommand() {
		Invoker invoker = new Invoker();
		Receiver receiver = new ConcreteReceiverA();
		Command command = new ConcreteCommandA(receiver);
		invoker.setCommand(command);
		invoker.action();
	}
	
	/**
	 *完美命令模式
	 */
	@Test
	public void testPerfactCommand(){
		PerfactfInvoker invoker = new PerfactfInvoker();
		PerfectCommand command = new PerfectConcreteCommandA();
		invoker.setCommand(command);
		invoker.action();
	}
}
