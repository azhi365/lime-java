/**
 * 
 * @author YZhi
 * @date 2012-5-22
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.structure.proxy.runner;

import java.util.Random;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class RunnerAgent implements IRunner {

	private IRunner runner;
	
	/**
	 * 
	 * 
	 * 
	 * @param runner
	 */
	public RunnerAgent(IRunner runner) {
		this.runner = runner;
	}


	/* (non-Javadoc)
	 * @see dp.example.structure.proxy.runner.IRunner#run()
	 */
	@Override
	public void run() {
		Random random = new Random();
		if(random.nextBoolean()){
			runner.run();
		}else {
			System.out.println("runner is not running");
		}
	}

}
