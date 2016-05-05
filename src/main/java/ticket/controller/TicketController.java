package ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ticket.dao.TicketDAO;
import ticket.model.Ticket;

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

        ticketDAO.insert(ticket);

        model.addAttribute("ticket", ticket);
        return "result";
    }
}
