package com.greatlearning.tickettracker.service;
import java.util.List;
import com.greatlearning.tickettracker.entity.ticket;
public interface TicketService {
		
	List<ticket> getAllTickets();
	ticket saveTicket(ticket ticket);
	
	ticket getTicketById(Long id);
	   
	ticket updateTicket(ticket ticket);

	void deleteTicketById(Long id);
}
