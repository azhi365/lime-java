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
public class UserProvider implements IUserProvider {

	private ArrayList<User> userList;
	
	/**
	 * 
	 * @param userList
	 */
	public UserProvider(ArrayList<User> userList) {
		this.userList = userList;
	}

	/* (non-Javadoc)
	 * @see dp.example.structure.adapter.specification.IUserProvider#findUserByAgeThan(int)
	 */
	@Override
	public ArrayList<User> findUserByAgeThan(int age) {
		ArrayList<User> result = new ArrayList<User>();
		for (User u : result) {
			if(u.getAge() > age){
				result.add(u);
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see dp.example.structure.adapter.specification.IUserProvider#findUserByNameEqual(java.lang.String)
	 */
	@Override
	public ArrayList<User> findUserByNameEqual(String name) {
		ArrayList<User> result = new ArrayList<User>();
		for (User u : result) {
			if(u.getName().equals(name)){
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
