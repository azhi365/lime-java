/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午04:13:23
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.decorator.score;

/**
 * 四年级成绩单
 * @author YZhi
 * @since 1.0
 */
public class FourGradeSchoolReport extends SchoolReport {

	/* (non-Javadoc)
	 * @see structure.decorator.example.Score.SchoolReport#report()
	 */
	@Override
	public void report() {
		System.out.println("score is 62");
	}

	public void sign(String name) {
		System.out.println("sign:" + name);
	}

}
