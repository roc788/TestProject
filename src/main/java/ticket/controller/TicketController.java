package ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ticket.dao.TicketDAO;
import ticket.model.Ticket;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class TicketController {

    @Autowired
    TicketDAO ticketDAO;

    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
    public String ticketForm(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "ticket";
    }

    @RequestMapping(value="/ticket", method=RequestMethod.POST)
    public String ticketSubmit(@ModelAttribute Ticket ticket, Model model) {

        Long record;

        record = ticketDAO.insert(ticket);
        ticket.setTicketId(record);

        model.addAttribute("ticket", ticket);
        return "result";
    }
}
