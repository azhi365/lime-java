/**
 * 
 * @author YZhi
 * @date 2012-5-31
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.adapter.specification;


/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class UserByNameEqual implements IUserSpecification {
	private String name;
	
	/**
	 * 
	 * @param name
	 */
	public UserByNameEqual(String name) {
		super();
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see dp.example.structure.adapter.specification.IUserSpecification#isSatisfiedBy(dp.example.structure.adapter.specification.User)
	 */
	@Override
	public boolean isSatisfiedBy(User user) {
		return user.getName().equals(name);
	}
	



}
