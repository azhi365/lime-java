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
public class CompositeSpecification implements ISpecification {

	/* (non-Javadoc)
	 * @see dp.structure.specification.ISpecification#and(dp.structure.specification.ISpecification)
	 */
	@Override
	public ISpecification and(ISpecification spec) {
		return null;
	}

	/* (non-Javadoc)
	 * @see dp.structure.specification.ISpecification#isSatisfiedBy(java.lang.Object)
	 */
	@Override
	public boolean isSatisfiedBy(Object candidate) {
		return false;
	}

	/* (non-Javadoc)
	 * @see dp.structure.specification.ISpecification#not()
	 */
	@Override
	public ISpecification not() {
		return null;
	}

	/* (non-Javadoc)
	 * @see dp.structure.specification.ISpecification#or(dp.structure.specification.ISpecification)
	 */
	@Override
	public ISpecification or(ISpecification spec) {
		return null;
	}

}
