/**
 * 
 * @author YZhi
 * @date 2012-5-29
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.structure.bridge.star;

/**
 * 抽象明星
 * @author YZhi
 * @since 1.0
 */
public abstract class AbsStar {
	protected final AbsAction action;

	public AbsStar(AbsAction action) {
		super();
		this.action = action;
	}
	public void doJob(){
		this.action.desc();
	}
}
