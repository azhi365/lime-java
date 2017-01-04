/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.behaviour.command.zip;

/**
 * 抽象接收者
 * @author YZhi
 * @since 1.0
 */
public interface IReceiver {
	public boolean compress(String source,String to);
	public boolean uncompress(String source,String to);
}
