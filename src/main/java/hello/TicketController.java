package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TicketController {

    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
    public String ticketForm(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "ticket";
    }

    @RequestMapping(value="/ticket", method=RequestMethod.POST)
    public String ticketSubmit(@ModelAttribute Ticket ticket, Model model) {
        model.addAttribute("ticket", ticket);
        return "result";
    }
}
