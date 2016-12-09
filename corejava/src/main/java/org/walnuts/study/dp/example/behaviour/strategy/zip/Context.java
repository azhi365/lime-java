/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.strategy.zip;

/**
 * 环境角色
 * @author YZhi
 * @since 1.0
 */
public class Context {
	private Algorithm algorithm;

	/**
	 * 
	 * 
	 * 
	 * @param algorithm
	 */
	public Context(Algorithm algorithm) {
		super();
		this.algorithm = algorithm;
	}
	
	public boolean compress(String source,String to) {
		return this.algorithm.compress(source, to);
	}
	public boolean uncompress(String source,String to) {
		return this.algorithm.uncompress(source, to);
	}
}
