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

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public interface IUserProviderSpec {
	public ArrayList<User> findUser(IUserSpecification userSpec);
}
