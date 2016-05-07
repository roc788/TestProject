package ticket;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import ticket.notifier.impl.SimpleNotificationManager;

@SpringBootApplication
public class Application {



    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

}