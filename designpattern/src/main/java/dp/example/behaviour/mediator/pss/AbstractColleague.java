/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午10:47:53
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.mediator.pss;

/**
 * 抽象同事类
 * @author YZhi
 * @since 1.0
 */
public class AbstractColleague {
	protected AbstractMediator mediator;
	public AbstractColleague(AbstractMediator mediator){
		this.mediator = mediator;
	}
}
