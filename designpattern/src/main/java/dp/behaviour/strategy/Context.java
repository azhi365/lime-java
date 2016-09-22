/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午04:23:55
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.behaviour.strategy;

/**
 * 封闭角色
 * @author YZhi
 * @since 1.0
 */
public class Context {
	private Strategy strategy = null;
	public Context(Strategy strategy){
		this.strategy = strategy;
	}
	public void doAnything(){
		this.strategy.doSomething();
	}
}
