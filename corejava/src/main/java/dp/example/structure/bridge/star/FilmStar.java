/**
 * 
 * @author YZhi
 * @date 2012-5-29
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.structure.bridge.star;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class FilmStar extends AbsStar {
	public FilmStar(){
		super(new ActFilm());
	}
	public FilmStar(AbsAction action){
		super(action);
	}
	
	/* (non-Javadoc)
	 * @see dp.example.structure.bridge.star.AbsStar#doJob()
	 */
	@Override
	public void doJob() {
		super.doJob();
	}
	
}
