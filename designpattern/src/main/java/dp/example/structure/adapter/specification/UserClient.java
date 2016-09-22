/**
 * 
 * @author YZhi
 * @date 2012-5-31
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.structure.adapter.specification;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 规格模式
 * @author YZhi
 * @since 1.0
 */
public class UserClient {
	/**
	 * 未使用规格模式
	 */
	@Test
	public void testUser(){
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User("A", 1));
		userList.add(new User("B", 2));
		userList.add(new User("C", 3));
		userList.add(new User("D", 4));
		userList.add(new User("E", 5));
		userList.add(new User("F", 6));
		IUserProvider userProvider = new UserProvider(userList);
		for (User u : userProvider.findUserByAgeThan(3)) {
			System.out.println(u);
		}
	}
	
	/**
	 * 规格模式
	 */
	@Test
	public void testUserSpec(){
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User("A", 1));
		userList.add(new User("B", 2));
		userList.add(new User("C", 3));
		userList.add(new User("D", 4));
		userList.add(new User("E", 5));
		userList.add(new User("F", 6));
		IUserProviderSpec userProviderSpec = new UserProviderSpec(userList);
		IUserSpecification userSpec = new UserByAgeThan(2);
		for (User u : userProviderSpec.findUser(userSpec)) {
			System.out.println(u);
		}
		
		userSpec = new UserByNameLike("C");
		for (User u : userProviderSpec.findUser(userSpec)) {
			System.out.println(u);
		}
	}

	
}
