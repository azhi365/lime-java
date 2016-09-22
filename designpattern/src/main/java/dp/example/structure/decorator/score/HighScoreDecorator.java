/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午04:08:03
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.decorator.score;

/**
 * 最高成绩修饰
 * @author YZhi
 * @since 1.0
 */
public class HighScoreDecorator extends Decorator {
	public HighScoreDecorator(SchoolReport sr){
		super(sr);
	}
	
	/* (non-Javadoc)
	 * @see structure.decorator.example.Score.Decorator#report()
	 */
	@Override
	public void report() {
		this.reportHigh();
		super.report();
	}


	private void reportHigh(){
		System.out.println("the high is 75");
	}
	
}
