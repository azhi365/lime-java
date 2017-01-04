/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午05:13:47
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.creation.builder.carmodel;

import java.util.ArrayList;

/**
 * 抽象汽车组装者
 * @author YZhi
 * @since 1.0
 */
public abstract class CarBuilder {
	public abstract void setSequence(ArrayList<String> sequence);
	public abstract CarModel getCarModel();
}
