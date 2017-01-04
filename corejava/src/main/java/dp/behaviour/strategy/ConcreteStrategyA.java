/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午04:22:48
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.behaviour.strategy;

/**
 * 具体策略角色A
 * @author YZhi
 * @since 1.0
 */
public class ConcreteStrategyA implements Strategy {

	/* (non-Javadoc)
	 * @see behaviour.strategy.Strategy#doSomething()
	 */
	@Override
	public void doSomething() {
		System.out.println("doSomething in ConcreteStrategyA");
	}

}
