/**
 * 
 * @author YZhi
 * @date 2012-5-31
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.structure.specification;

/**
 * 非规格书
 * @author YZhi
 * @since 1.0
 */
public class NotOrSpecification extends CompositeSpecification {
	private ISpecification spec;
	
	
	/**
	 * 
	 * @param spec
	 */
	public NotOrSpecification(ISpecification spec) {
		super();
		this.spec = spec;
	}


	/* (non-Javadoc)
	 * @see dp.structure.specification.CompositeSpecification#isSatisfiedBy(java.lang.Object)
	 */
	@Override
	public boolean isSatisfiedBy(Object candidate) {
		return !spec.isSatisfiedBy(candidate);
	}
	
}
