/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午03:23:21
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.creation.factorymethod;

import java.util.HashMap;
import java.util.Map;

/**
 * 延迟加载的工厂类
 * @author YZhi
 * @since 1.0
 */
public class ProductFactory {
	private static final Map<String, Product> prMap = new HashMap<String, Product>();
	public static synchronized Product createProduct(String type) throws Exception{
		Product product = null;
		if(prMap.containsKey(type)){
			product = prMap.get(type);
		}else {
			if(type.equals("Product1")){
				product  = new ConcreteProduct1();
			}else {
				product = new ConcreteProduct2();
			}
			prMap.put(type, product);
		}
		return product;
	}
}
