/**
 * 
 * @author YZhi
 * @date 2012-5-22
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.structure.proxy.runner;

/**
 * 运动员
 * @author YZhi
 * @since 1.0
 */
public class Runner implements IRunner {

	/* (non-Javadoc)
	 * @see dp.example.structure.proxy.runner.IRunner#run()
	 */
	@Override
	public void run() {
		System.out.println("Runner is running");
	}

}
