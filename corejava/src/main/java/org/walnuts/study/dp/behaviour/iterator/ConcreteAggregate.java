/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午10:16:05
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.behaviour.iterator;

import java.util.Vector;

/**
 * 具体容器
 * @author YZhi
 * @since 1.0
 */
public class ConcreteAggregate implements Aggregate {
	public Vector<Aggregate> vector = new Vector<Aggregate>();
	
	

	/* (non-Javadoc)
	 * @see behaviour.iterator.Aggregate#add(behaviour.iterator.Aggregate)
	 */
	@Override
	public void add(Aggregate aggregate) {
		this.vector.add(aggregate);
	}



	/* (non-Javadoc)
	 * @see behaviour.iterator.Aggregate#iterator()
	 */
	@Override
	public Iterator<Aggregate> iterator() {
		return new ConcreteIterator<Aggregate>(vector);
	}
	/* (non-Javadoc)
	 * @see behaviour.iterator.Aggregate#remove(behaviour.iterator.Aggregate)
	 */
	@Override
	public void remove(Aggregate aggregate) {
		this.remove(aggregate);
	}
}
