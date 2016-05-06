package ticket.dao;

import org.springframework.stereotype.Component;
import ticket.model.Ticket;

public interface TicketDAO {
    public Long insert(Ticket ticket);
    public Ticket findByTicketId(int ticketId);
}
