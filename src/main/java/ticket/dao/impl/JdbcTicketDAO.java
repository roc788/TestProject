package ticket.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ticket.dao.TicketDAO;
import ticket.model.Ticket;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTicketDAO implements TicketDAO {

    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Ticket ticket){

        String sql = "INSERT INTO TICKET " +
                "(TICKET_ID, NAME, NUMBER, EMAIL) VALUES (?, ?, ?, ?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(
                sql,
                new Object[] {ticket.getTicketId(), ticket.getName(), ticket.getNumber(), ticket.getEmail()}
        );
    }

    public Ticket findByTicketId(int ticketId){

        String sql = "SELECT * FROM TICKET WHERE TICKET_ID=" + ticketId;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Ticket> tickets = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Ticket.class));
        return tickets.get(0);
    }
}
