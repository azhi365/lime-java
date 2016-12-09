/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.strategy.life;

import org.junit.Test;

import org.walnuts.study.dp.example.behaviour.state.life.AdultState;
import org.walnuts.study.dp.example.behaviour.state.life.ChildState;
import org.walnuts.study.dp.example.behaviour.state.life.Human;
import org.walnuts.study.dp.example.behaviour.state.life.OldState;

/**
 * <pre>
 * 策略模式VS状态模式
 * 环境角色的职责不同
 * 策略模式解决问题算法的改变对外界的影响降低到最小程度，状态模式解决内在状态的改变而引起行为改变的问题
 * 解决问题的方法不同，应用场景不同，复杂度不同
 * </pre>
 * @author YZhi
 * @since 1.0
 */
public class LifeClient {
	
	/**
	 * 策略模式工作
	 */
	@Test
	public void testLifeStrategy(){
		Context context = new Context();
		context.setWorkAlgorithm(new ChildWork());
		context.work();
		context.setWorkAlgorithm(new AdultWork());
		context.work();
		context.setWorkAlgorithm(new OldWork());
		context.work();
	}
	
	/**
	 *状态模式
	 */
	@Test
	public void testLifeState(){
		Human human = new Human();
		human.setState(new ChildState());
		human.work();
		human.setState(new AdultState());
		human.work();
		human.setState(new OldState());
		human.work();
	}
}
