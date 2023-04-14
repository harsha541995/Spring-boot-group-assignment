package com.greatlearning.tickettracker.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greatlearning.tickettracker.entity.ticket;
import com.greatlearning.tickettracker.repository.TicketRepository;
import com.greatlearning.tickettracker.service.TicketService;
@Service
public class TicketServiceImpl implements TicketService{
	@Autowired
   private TicketRepository ticketRepository;
 
   @Override
   public List<ticket> getAllTickets() {
       return ticketRepository.findAll();
   }

   @Override
   public ticket saveTicket(ticket ticket) {
       return ticketRepository.save(ticket);
   }
   
   @Override
   public ticket getTicketById(Long id) {
       return ticketRepository.findById(id).get();
   }

   @Override
   public ticket updateTicket(ticket ticket) {
       return ticketRepository.save(ticket);
   }

   @Override
   public void deleteTicketById(Long id) {
       ticketRepository.deleteById(id);
   }



}
