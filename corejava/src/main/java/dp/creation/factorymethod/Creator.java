/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午02:42:10
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.creation.factorymethod;

/**
 * 抽象工厂类
 * @author YZhi
 * @since 1.0
 */
public abstract class Creator {
	 public abstract <T extends Product> T createProduct(Class<T> c);
}
