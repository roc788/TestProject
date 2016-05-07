package ticket.notifier;

import ticket.model.Ticket;

public interface NotificationManager {

    public void sendEmail(Ticket ticket);
}
