/**
 * 
 * @author YZhi
 * @date 2012-5-31
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.adapter.specification;

import java.util.ArrayList;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class UserProviderSpec implements IUserProviderSpec {
	private ArrayList<User> userList;
	
	/**
	 * 
	 * @param userList
	 */
	public UserProviderSpec(ArrayList<User> userList) {
		super();
		this.userList = userList;
	}


	/* (non-Javadoc)
	 * @see dp.example.structure.adapter.specification.IUserProviderSpec#findUser(dp.example.structure.adapter.specification.IUserSpecification)
	 */
	@Override
	public ArrayList<User> findUser(IUserSpecification userSpec) {
		ArrayList<User> result = new ArrayList<User>();
		for (User u : userList) {
			if(userSpec.isSatisfiedBy(u)){
				result.add(u);
			}
		}
		return result;
	}


	public ArrayList<User> getUserList() {
		return userList;
	}


	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	

}
