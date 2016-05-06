package ticket;

import org.springframework.jdbc.core.RowMapper;
import ticket.model.Ticket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketMapper implements RowMapper<Ticket> {
    public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setTicketId(rs.getLong("TICKET_ID"));
        ticket.setName(rs.getString("NAME"));
        ticket.setNumber(rs.getString("NUMBER"));
        ticket.setEmail(rs.getString("EMAIL"));
        return ticket;
    }
}
