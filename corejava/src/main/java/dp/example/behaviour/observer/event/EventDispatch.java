/**
 * 
 * @author YZhi
 * @date 2012-5-30
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.behaviour.observer.event;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class EventDispatch implements Observer {
	private final static EventDispatch dispatch = new EventDispatch();
	private Vector<EventCustomer> customers = new Vector<EventCustomer>();
	private EventDispatch(){
		
	}
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		@SuppressWarnings("unused")
		Product product =  (Product)arg;
		ProductEvent event = (ProductEvent)o;
		for (EventCustomer e : customers) {
			for (EventCustomType t : e.getCustomType()) {
				if(t.getValue() == event.getType().getValue()){
					e.exec(event);
				}
			}
		}
	}
	
	public void registerCustomer(EventCustomer customer){
		this.customers.add(customer);
	}

	/**
	 *
	 * @return
	 */
	public static EventDispatch getEventDispatch() {
		return dispatch;
	}

}
