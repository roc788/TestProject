# Ticketing System

This simple web application is designed for a user to submit a ticket containing their
name, number, and email address.  Upon submission, an email is sent to them to confirm
the submission, along with the associated ticket number.  Additional features include
ticket deletion and ticket querying.

#URLs

Ticket generation form URL: http://localhost:8090/ticket<br />
Ticket query URL          : http://localhost:8090/admin/ticket/{ticket number}<br />
Ticket deletion form URL  : http://localhost:8090/admin/ticket/delete

# SQL

You must have mySQL running. You must specify your database name, username, and password.  This is done within
src/main/resources/application.properties. The table should be created as follows:

```
CREATE TABLE TICKET(
 TICKET_ID INT NOT NULL AUTO_INCREMENT,
 NAME VARCHAR(20) NOT NULL,
 NUMBER VARCHAR(12) NOT NULL,
 EMAIL VARCHAR(30) NOT NULL,
 PRIMARY KEY (TICKET_ID)
);
```

# Email Setup

You must specify the email account username and password that you wish to send notifications to. This is done within
src/main/resources/WEB-INF/spring-mail.xml.

# Run

To start application: $ ./gradlew clean bootRun (clean to avoid any conflicts after potential changes are made)

# Notes

For now, if you kill the application while on one of the application's pages, you may need to navigate to
another page the next time you start it rather than refreshing the page.