/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.behaviour.command.zip;

/**
 * Zip接收者
 * @author YZhi
 * @since 1.0
 */
public class ZipReceiver implements IReceiver {

	/* (non-Javadoc)
	 * @see dp.example.behaviour.command.zip.IReceiver#compress(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean compress(String source, String to) {
		System.out.println("Zip compress");
		return false;
	}

	/* (non-Javadoc)
	 * @see dp.example.behaviour.command.zip.IReceiver#uncompress(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean uncompress(String source, String to) {
		System.out.println("Zip uncompress");
		return false;
	}

}
