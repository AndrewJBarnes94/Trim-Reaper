package com.brocodesoftware.trimreaper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendQuoteEmail(String toEmail, String quoteNumber, Long quoteId) {
        String subject = "Your Trim Reaper Landscaping Quote";
        String quoteLink = "http://localhost:8080/quote/" + quoteId;

        String body = String.format(
            "Thanks for requesting a quote!\n\n" +
            "Your quote number is: %s\n" +
            "You can view and schedule your quote here:\n%s\n\n" +
            "Let us know if you have any questions!\n\n" +
            "- The Trim Reaper Team",
            quoteNumber, quoteLink
        );

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("andrew.barnes@brocodesoftware.com");

        mailSender.send(message);
    }

}
