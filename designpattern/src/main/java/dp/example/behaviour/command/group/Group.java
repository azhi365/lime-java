/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午11:37:19
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.command.group;

/**
 * 抽象组
 * @author YZhi
 * @since 1.0
 */
public abstract class Group {
	public abstract void find();
	public abstract void add();
	public abstract void delete();
	public abstract void change();
	public abstract void plan();
	public void rollBack(){
		
	}
}
