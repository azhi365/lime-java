/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午05:15:52
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.visitor.actor;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public interface Role {
	public void accept(AbsActor actor);
}
