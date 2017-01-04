/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午04:06:11
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.decorator.score;

/**
 * 修饰的抽象类
 * @author YZhi
 * @since 1.0
 */
public abstract class Decorator extends SchoolReport {
	private SchoolReport sr;
	public Decorator(SchoolReport sr){
		this.sr = sr;
	}
	/* (non-Javadoc)
	 * @see structure.decorator.example.Score.SchoolReport#report()
	 */
	@Override
	public void report() {
		this.sr.report();
	}
	/* (non-Javadoc)
	 * @see structure.decorator.example.Score.SchoolReport#sign()
	 */
	@Override
	public void sign(String name) {
		this.sr.sign(name);
	}
	
}
