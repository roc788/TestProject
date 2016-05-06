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

    @RequestMapping(value = "/admin/ticket/delete", method = RequestMethod.GET)
    public String deletionForm(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "delete-ticket";
    }

    @RequestMapping(value="/ticket", method=RequestMethod.POST)
    public String ticketSubmit(@ModelAttribute Ticket ticket, Model model) {

        Long record;

        record = ticketDAO.insert(ticket);
        ticket.setTicketId(record);

        model.addAttribute("ticket", ticket);
        return "result";
    }

    @RequestMapping(value = "/admin/ticket/delete", method = RequestMethod.POST)
    public String deleteTicket(@ModelAttribute Ticket ticket, Model model) {
        ticketDAO.delete(ticket.getTicketId());
        model.addAttribute("ticket", ticket);
        return "delete-confirmation";
    }

    @RequestMapping(value = "/admin/ticket/{id}", method = RequestMethod.GET)
    public String findTicket(Model model, @PathVariable Long id) {
        Ticket ticket = ticketDAO.findByTicketId(id);
        model.addAttribute("ticket", ticket);
        return "ticket-information";
    }
}
