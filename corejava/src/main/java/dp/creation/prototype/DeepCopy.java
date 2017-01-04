/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午10:24:57
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.creation.prototype;

import java.util.ArrayList;

/**
 * 深拷贝
 * @author yzhi
 * @version 1.0
 */
public class DeepCopy implements Cloneable {
	private ArrayList<String> arrayList = new ArrayList<String>();
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected DeepCopy clone(){
		DeepCopy deepCopy = null;
		try {
			deepCopy = (DeepCopy)super.clone();
			deepCopy.arrayList = (ArrayList<String>)this.arrayList.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deepCopy;
	}
	//-------------------
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
