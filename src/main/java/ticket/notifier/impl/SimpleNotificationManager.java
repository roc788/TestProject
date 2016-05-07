package ticket.notifier.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import ticket.model.Ticket;
import ticket.notifier.NotificationManager;

@Component
public class SimpleNotificationManager implements NotificationManager {

    public ApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring-mail.xml");
    MailSender mailSender = (MailSender) context.getBean("mailSender");

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    /*public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }*/

    public void sendEmail(Ticket ticket){

        //SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(ticket.getEmail());
        msg.setSubject("Ticket Status");
        msg.setText(
                "Hello " + ticket.getName() + ",\n\n"
                        + "Thank you for submitting an online ticket. Your ticket number is "
                        + ticket.getTicketId() + ".  You will be contacted at the recommended time for you to head to Montebello.");
        try{
            mailSender.send(msg);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }

    }
}
