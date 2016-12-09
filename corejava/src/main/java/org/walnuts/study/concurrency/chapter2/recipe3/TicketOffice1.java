package org.walnuts.study.concurrency.chapter2.recipe3;

/**
 * This class simulates a ticket office. It sell or return tickets
 * for the two cinemas
 *
 */
public class TicketOffice1 implements Runnable {

	private Cinema cinema;

	public TicketOffice1 (Cinema cinema) {
		this.cinema=cinema;
	}
	
	@Override
	public void run() {
		cinema.sellTickets1(3);
		cinema.sellTickets1(2);
		cinema.sellTickets2(2);
		cinema.returnTickets1(3);
		cinema.sellTickets1(5);
		cinema.sellTickets2(2);
		cinema.sellTickets2(2);
		cinema.sellTickets2(2);
	}

}
