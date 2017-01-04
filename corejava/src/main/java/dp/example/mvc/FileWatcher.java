/**
 * @author YZhi
 * @date 2012-5-31
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.mvc;

import java.util.Observable;

/**
 * 文件监听者
 * @author YZhi
 * @since 1.0
 */
public class FileWatcher extends Observable implements Watchable {
	private boolean isReload = false;
	/* (non-Javadoc)
	 * @see dp.example.mvc.Watchable#watch()
	 */
	@Override
	public void watch() {
		super.addObserver(new Checker());
		super.setChanged();
		super.notifyObservers(isReload);
	}

}
