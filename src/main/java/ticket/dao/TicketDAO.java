package ticket.dao;

import ticket.model.Ticket;

public interface TicketDAO {
    public void insert(Ticket ticket);
    public Ticket findByTicketId(int ticketId);
}
