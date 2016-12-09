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
 * 电影明星
 * @author YZhi
 * @since 1.0
 */
public class FilmStar implements IStar {
	public void act(){
		System.out.println("FilmStar act");
	}
}
