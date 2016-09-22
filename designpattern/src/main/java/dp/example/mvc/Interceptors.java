/**
 * 
 * @author YZhi
 * @date 2012-5-31
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.mvc;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class Interceptors implements Iterable<AbstractInterceptor> {
	public Interceptors(ArrayList<AbstractInterceptor> list){
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<AbstractInterceptor> iterator() {
		return null;
	}
	
	public void intercept(){
		
	}

}
