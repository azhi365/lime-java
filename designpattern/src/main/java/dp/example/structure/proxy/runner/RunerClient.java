/**
 * 
 * @author YZhi
 * @date 2012-5-22
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.structure.proxy.runner;

import org.junit.Test;

import dp.example.structure.decorator.runner.RunnerWithJet;

/**
 * <pre>
 * 代理模式VS装饰模式
 * 具有相同的接口，代理模式着重对代理过程的控制,装饰模式对类的加强或减弱
 * </pre>
 * @author YZhi
 * @since 1.0
 */
public class RunerClient {
	/**
	 *代理模式
	 */
	@Test
	public void testRunner(){
		IRunner liu = new Runner();
		IRunner agent = new RunnerAgent(liu);
		agent.run();
	}
	
	/**
	 *装饰模式
	 */
	@Test
	public void testRunnerDecorator(){
		IRunner liu = new Runner();
		liu = new RunnerWithJet(liu);
		liu.run();
	}
}
