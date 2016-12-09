/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.command.zip;

/**
 * Gzip解压命令
 * @author YZhi
 * @since 1.0
 */
public class GzipUncompressCmd extends AbstractCmd {

	/* (non-Javadoc)
	 * @see dp.example.behaviour.command.zip.AbstractCmd#execute(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean execute(String source, String to) {
		return super.gzip.uncompress(source, to);
	}

}
