/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午04:06:24
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.creation.abstractfactory.human;

/**
 * 白色人种
 * @author YZhi
 * @since 1.0
 */
public abstract class AbstractWhiteHuman implements Human {

	/* (non-Javadoc)
	 * @see creation.abstractfactory.example.human.Human#getColor()
	 */
	@Override
	public void getColor() {
		System.out.println("White");
	}

	/* (non-Javadoc)
	 * @see creation.abstractfactory.example.human.Human#talk()
	 */
	@Override
	public void talk() {
		System.out.println("White talk");
	}

}
