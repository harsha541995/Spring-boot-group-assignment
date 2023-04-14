package com.greatlearning.tickettracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.tickettracker.service.TicketService;
import com.greatlearning.tickettracker.entity.ticket;


@Controller
public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
   
    @GetMapping("/tickets")
    public String listTickets(Model model) {
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "tickets";
    }  
   
    
    @GetMapping("/tickets/new")
    public String createTicketForm(Model model) {

        // create ticket object to hold ticket form data
        ticket ticket = new ticket();
        model.addAttribute("ticket", ticket);
        return "create_ticket";
    }

   @PostMapping("/tickets")
    public String saveTicket(
            @ModelAttribute("ticket") ticket ticket) {
        ticketService.saveTicket(ticket);
        return "redirect:/tickets";
    }  

    
	@GetMapping("/tickets/edit/{id}")
	public String editTicketForm(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "edit_ticket";
	}

	@PostMapping("/tickets/{id}")
	public String updateTicket(
			@PathVariable Long id, 
			@ModelAttribute("ticket") ticket ticket, 
			Model model) {

		// get ticket from database by id
		ticket existingTicket = ticketService.getTicketById(id);
		existingTicket.setId(id);
		existingTicket.setTitle(ticket.getTitle());
		existingTicket.setDescription(ticket.getDescription());
		existingTicket.setContent(ticket.getContent());

		// save updated ticket object
		ticketService.updateTicket(existingTicket);
		return "redirect:/tickets";
	}

   
	@GetMapping("/tickets/{id}/delete")
	    public String deleteTicket(@PathVariable Long id) {
	        ticketService.deleteTicketById(id);
	        return "redirect:/tickets";
	   }

   
    @GetMapping("/tickets/{id}")
	public String ticketCard(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "ticket_details";
    } 
	
	
}
