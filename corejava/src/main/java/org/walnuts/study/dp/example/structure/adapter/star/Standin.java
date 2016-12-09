/**
 * 
 * @author YZhi
 * @date 2012-5-29
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.adapter.star;

import org.walnuts.study.dp.example.structure.proxy.star.IStar;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class Standin implements IStar {
	private IActor actor;
	
	/* (non-Javadoc)
	 * @see dp.example.structure.proxy.star.IStar#act()
	 */
	@Override
	public void act() {
		actor.playAct();
	}
	
	public Standin(IActor actor){
		this.actor = actor;
	}

}
