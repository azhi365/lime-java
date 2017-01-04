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
 * 压缩命令接收者
 * @author YZhi
 * @since 1.0
 */
public class CompressReceiver implements IReceiverB {

	/* (non-Javadoc)
	 * @see dp.example.behaviour.command.zip.IReceiverB#gzipExec(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean gzipExec(String source, String to) {
		System.out.println("Gzip compress Successed");
		return false;
	}

	/* (non-Javadoc)
	 * @see dp.example.behaviour.command.zip.IReceiverB#zipExec(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean zipExec(String source, String to) {
		System.out.println("zip compress Successed");
		return false;
	}

}
