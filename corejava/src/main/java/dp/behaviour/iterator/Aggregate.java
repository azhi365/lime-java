/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午10:14:53
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.behaviour.iterator;

/**
 * 抽象容器
 * @author YZhi
 * @since 1.0
 */
public interface Aggregate {
	public void add(Aggregate aggregate);
	public void remove(Aggregate aggregate);
	public Iterator<Aggregate> iterator();
}
