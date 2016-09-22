/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午04:25:34
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.behaviour.strategy;

import org.junit.Test;

/**
 * 
 * <pre>
 * 
 * 一、定义
 *     策略模式(Strategy Pattern)也称政策模式(Policy Pattern)
 *     1、Define a family of algorithms,encapsulate each one and make them interchangeable.
 *     定义一组算法，将每个算法都封装起来，并且使它们之间可以互换
 *     
 * 二、优点
 *     算法可以自由切换、避免使用多重条件判断、扩展性良好
 * 三、缺点
 *     策略类数量增多、所有的策略类都需要对外暴露
 * 四、条件
 *     
 * 五、适用性
 *     多个类只有在算法和行为上稍有不同的场景、算法需要自由切换、需要屏蔽算法规则的场景
 * 六、最佳实践
 *     
 * </pre>
 * 
 * <img src="doc-files/strategy.png" />
 * @author yzhi
 */
public class StrategyClient {
	@Test
	public void testStrategy(){
		Strategy strategy = new ConcreteStrategyA();
		Context context = new Context(strategy);
		context.doAnything();
	}
}
