/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午04:05:26
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.decorator.score;

import org.junit.Test;

/**
 * 父亲类(场景类)
 * @author YZhi
 * @since 1.0
 */
public class Father {
	@Test
	public void testDecorator(){
		SchoolReport sr = new FourGradeSchoolReport();
		sr = new HighScoreDecorator(sr);
		sr = new SortDecorator(sr);
		sr.report();
		sr.sign("father");
	}
}
