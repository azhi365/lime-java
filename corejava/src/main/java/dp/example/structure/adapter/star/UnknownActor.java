/**
 * 
 * @author YZhi
 * @date 2012-5-29
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.structure.adapter.star;

/**
 * 普通演员
 * @author YZhi
 * @since 1.0
 */
public class UnknownActor implements IActor {

	/* (non-Javadoc)
	 * @see dp.example.structure.adapter.star.IActor#playAct()
	 */
	@Override
	public void playAct() {
		System.out.println("UnknownActor playAct");
	}

}
