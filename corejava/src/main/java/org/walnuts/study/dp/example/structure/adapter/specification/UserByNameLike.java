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
public class UserByNameLike implements IUserSpecification {
	
	private final static String LIKE_FLAG = "%";
	private String likeStr;
	
	/**
	 * 
	 * @param likeStr
	 */
	public UserByNameLike(String likeStr) {
		super();
		this.likeStr = likeStr;
	}
	
	/* (non-Javadoc)
	 * @see dp.example.structure.adapter.specification.IUserSpecification#isSatisfiedBy(dp.example.structure.adapter.specification.User)
	 */
	@Override
	public boolean isSatisfiedBy(User user) {
		boolean result = false;
		String name = user.getName();
		String str = likeStr.replace("%", " ");
		if(likeStr.endsWith(LIKE_FLAG) && !likeStr.startsWith(LIKE_FLAG)){
			result = name.startsWith(str);
		}else if (likeStr.startsWith(LIKE_FLAG) && !likeStr.endsWith(LIKE_FLAG)) {
			result = name.endsWith(str);
		}else {
			result = name.contains(str);
		}
		return result;
	}

}
