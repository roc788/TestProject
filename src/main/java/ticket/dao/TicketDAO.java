package ticket.dao;

import ticket.model.Ticket;

public interface TicketDAO {
    public Long insert(Ticket ticket);
    public Ticket findByTicketId(Long ticketId);
    public void delete(Long ticketId);
}
