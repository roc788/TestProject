package ticket.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ticket.TicketMapper;
import ticket.dao.TicketDAO;
import ticket.model.Ticket;
import javax.sql.DataSource;

@Repository
public class JdbcTicketDAO implements TicketDAO {

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Long insert(Ticket ticket){

        String sql = "INSERT INTO TICKET " +
                "(TICKET_ID, NAME, NUMBER, EMAIL) VALUES (?, ?, ?, ?)";
        String sql_query = "SELECT * FROM TICKET WHERE TICKET_ID = (SELECT MAX(TICKET_ID) FROM TICKET WHERE " +
                "NAME = ? AND NUMBER = ? AND EMAIL = ?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(
                sql,
                new Object[] {ticket.getTicketId(), ticket.getName(), ticket.getNumber(), ticket.getEmail()}
        );

        Long record = jdbcTemplate.queryForObject(sql_query,
                new Object[]{ticket.getName(), ticket.getNumber(), ticket.getEmail()},
                new TicketMapper()
        ).getTicketId();

        return record;
    }

    public Ticket findByTicketId(Long ticketId){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM TICKET WHERE TICKET_ID= ?";
        Ticket ticket = jdbcTemplate.queryForObject(sql, new Object[]{ticketId}, new TicketMapper());
        return ticket;
    }

    public void delete(Long ticketId){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "DELETE FROM TICKET WHERE TICKET_ID= ?";
        jdbcTemplate.update(sql, new Object[]{ticketId});
        return;
    }
}
