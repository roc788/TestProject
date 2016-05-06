package ticket;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String args[]) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/ApplicationContext.xml");
        SpringApplication.run(Application.class, args);
    }

}