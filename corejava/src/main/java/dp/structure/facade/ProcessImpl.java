/**
 * 
 */
package dp.structure.facade;

/**
 * 子系统实现
 * @author YZhi
 * @since 1.0
 */
public class ProcessImpl implements Process {

	/* (non-Javadoc)
	 * @see com.facade.IProcess#stepOne()
	 */
	@Override
	public void stepOne() {
		System.out.println("step One");
	}

	/* (non-Javadoc)
	 * @see com.facade.IProcess#stepThree()
	 */
	@Override
	public void stepThree() {
		System.out.println("step Three");
	}

	/* (non-Javadoc)
	 * @see com.facade.IProcess#stepTwo()
	 */
	@Override
	public void stepTwo() {
		System.out.println("step Two");
	}

}
