/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午04:07:45
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.creation.abstractfactory.human;

/**
 * 白色女性人种
 * @author YZhi
 * @since 1.0
 */
public class FemaleWhiteHuman extends AbstractWhiteHuman {

	/* (non-Javadoc)
	 * @see creation.abstractfactory.example.human.Human#getSex()
	 */
	@Override
	public void getSex() {
		System.out.println("White Female");
	}

}
