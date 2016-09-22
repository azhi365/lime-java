/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.behaviour.strategy.zip;

/**
 * 抽象压缩算法
 * @author YZhi
 * @since 1.0
 */
public interface Algorithm {
	/**
	 * 压缩算法
	 *
	 * @param source
	 * @param to
	 * @return
	 */
	public boolean compress(String source,String to);
	/**
	 * 
	 * 解压缩算法
	 * @param source
	 * @param to
	 * @return
	 */
	public boolean uncompress(String source,String to);
}
