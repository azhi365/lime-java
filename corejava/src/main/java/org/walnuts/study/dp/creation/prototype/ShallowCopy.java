/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午10:19:17
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.creation.prototype;

import java.util.ArrayList;

/**
 * 浅拷贝
 * @author YZhi
 * @since 1.0
 */
public class ShallowCopy implements Cloneable {
	private ArrayList<String> arrayList = new ArrayList<String>();
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected ShallowCopy clone(){
		ShallowCopy shallowCopy = null;
		try {
			shallowCopy = (ShallowCopy)super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shallowCopy;
	}
	//----------------------------------
	/**
	 * @return the arrayList
	 */
	public ArrayList<String> getArrayList() {
		return arrayList;
	}

	/**
	 * @param arrayList the arrayList to set
	 */
	public void setArrayList(ArrayList<String> arrayList) {
		this.arrayList = arrayList;
	}
	
}
