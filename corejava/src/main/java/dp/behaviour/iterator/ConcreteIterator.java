/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午10:09:57
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.behaviour.iterator;

import java.util.Vector;

/**
 * 具体迭代器
 * @author YZhi
 * @since 1.0
 * @param <E>
 */
public class ConcreteIterator<E> implements Iterator<E> {
	private Vector<E> vector = new Vector<E>();
	public int cursor = 0;
	/**
	 * 
	 * 
	 * 
	 * @param vector
	 */
	public ConcreteIterator(Vector<E> vector) {
		this.vector = vector;
	}
	/* (non-Javadoc)
	 * @see behaviour.iterator.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		if(this.cursor == this.vector.size()){
			return false;
		}else {
			return true;
		}
	}
	/* (non-Javadoc)
	 * @see behaviour.iterator.Iterator#next()
	 */
	@Override
	public Object next() {
		Object result = null;
		if(this.hasNext()){
			result = this.vector.get(this.cursor++);
		}else {
			result = null;
		}
		return result;
	}
	/* (non-Javadoc)
	 * @see behaviour.iterator.Iterator#remove()
	 */
	@Override
	public boolean remove() {
		this.vector.remove(this.cursor);
		return true;
	}
	
}
