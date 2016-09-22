/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.behaviour.strategy.zip;

/**
 * Zip
 * @author YZhi
 * @since 1.0
 */
public class Zip implements Algorithm {

	/* (non-Javadoc)
	 * @see dp.example.behaviour.strategy.zip.Algorithm#compress(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean compress(String source, String to) {
			System.out.println("Zip compress");
		return false;
	}

	/* (non-Javadoc)
	 * @see dp.example.behaviour.strategy.zip.Algorithm#upcompress(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean uncompress(String source, String to) {
		System.out.println("Zip upcompress");
		return false;
	}

}
