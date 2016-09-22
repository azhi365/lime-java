/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午04:30:02
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.strategy.zhaoyun;

/**
 * 锦囊
 * @author YZhi
 * @since 1.0
 */
public class Context {
	private IStrategy strategy;
	public Context(IStrategy strategy){
		this.strategy = strategy;
	}
	public void operate(){
		this.strategy.operate();
	}
}
