/**
 * 
 * @author YZhi
 * @date 2012-5-31
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.structure.specification;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class BizSpecification extends CompositeSpecification {
	private Object obj;

	/**
	 * 
	 * @param obj
	 */
	public BizSpecification(Object obj) {
		this.setObj(obj);
	}
	/* (non-Javadoc)
	 * @see dp.structure.specification.CompositeSpecification#isSatisfiedBy(java.lang.Object)
	 */
	@Override
	public boolean isSatisfiedBy(Object candidate) {
		return false;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public Object getObj() {
		return obj;
	}
}
