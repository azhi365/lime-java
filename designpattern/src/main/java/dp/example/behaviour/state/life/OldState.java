/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.behaviour.state.life;

/**
 * 老年人状态
 * @author YZhi
 * @since 1.0
 */
public class OldState extends HumanState {

	/* (non-Javadoc)
	 * @see dp.example.behaviour.state.life.HumanState#work()
	 */
	@Override
	public void work() {
		System.out.println("Old work");
	}

}
