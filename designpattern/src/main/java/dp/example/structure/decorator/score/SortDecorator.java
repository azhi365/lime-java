/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午04:10:24
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.decorator.score;

/**
 * 排名情况修饰
 * @author YZhi
 * @since 1.0
 */
public class SortDecorator extends Decorator {
	public SortDecorator(SchoolReport sr){
		super(sr);
	}

	/* (non-Javadoc)
	 * @see structure.decorator.example.Score.Decorator#report()
	 */
	@Override
	public void report() {
		super.report();
		this.reportSort();
		
	}
	private void reportSort(){
		System.out.println("sort is NO.38");
	}
	
}
