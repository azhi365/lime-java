/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午04:55:30
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.creation.builder;

/**
 * 抽象创建者
 * @author YZhi
 * @since 1.0
 */
public abstract class Builder {
	public abstract void setPart();
	public abstract Product buildProduct();
}
