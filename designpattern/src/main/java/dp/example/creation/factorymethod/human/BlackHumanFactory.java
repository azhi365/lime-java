/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午03:08:44
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.creation.factorymethod.human;

/**
 * 黑色人种的创建类
 * @author YZhi
 * @since 1.0
 */
public class BlackHumanFactory extends AbstractHumanMultiFactory {

	/* (non-Javadoc)
	 * @see creation.factorymethod.example.human.AbstractHumanMultiFactory#createHuman()
	 */
	@Override
	public Human createHuman() {
		return new BlackHuman();
	}
	
}
