/**
 * 
 * @author YZhi
 * @date 2012-5-22
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.structure.decorator.runner;

import dp.example.structure.proxy.runner.IRunner;

/**
 * 修饰类与代理模式对比
 * @author YZhi
 * @since 1.0
 */
public class RunnerWithJet implements IRunner {

	private IRunner runner;
	
	/**
	 * 
	 * 
	 * 
	 * @param runner
	 */
	public RunnerWithJet(IRunner runner) {
		this.runner = runner;
	}

	/* (non-Javadoc)
	 * @see dp.example.structure.proxy.runner.IRunner#run()
	 */
	@Override
	public void run() {
		System.out.println("other out");
		runner.run();
	}

}
