/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午04:58:33
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.creation.builder;


/**
 * 导演类
 * @author YZhi
 * @since 1.0
 */
public class Director {
	private Builder builder = new ConcreteBuilder();
	public Product getAProduct(){
		builder.setPart();
		return builder.buildProduct();
	}
}
