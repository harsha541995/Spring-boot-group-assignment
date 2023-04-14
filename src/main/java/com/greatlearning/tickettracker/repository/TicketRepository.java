package com.greatlearning.tickettracker.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.greatlearning.tickettracker.entity.ticket;

public interface TicketRepository extends JpaRepository<ticket, Long>{
}
