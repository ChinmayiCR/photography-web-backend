package com.photographyweb.web.email;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.photographyweb.web.constants.AppConstants;
import com.photographyweb.web.pojo.EmailBody;
import com.photographyweb.web.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.smartcardio.CardTerminal;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender mailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender) { // Constructor injection is safer
        this.mailSender = mailSender;
    }

    public void sendEmail(EmailBody emailBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailBody.getSender());
        message.setTo(AppConstants.RECIPIENT);
        message.setSubject(AppConstants.SUBJECT + emailBody.getSenderName());

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            StringBuilder itemsBuilder = new StringBuilder();
            for (Order item : emailBody.getSenderOrder()) {
                itemsBuilder.append("- ")
                        .append(item.getTitle())
                        .append(" – Price: $").append(item.getPrice())
                        .append("\n");
            }

            // Build full email body
            String messageBody = "You have an order from " + emailBody.getSenderName() + ",\n\n"
                    + "Order Summary:\n"
                    + "Items Ordered:\n" + itemsBuilder.toString() + "\n"
                    + "Client Phone Number:\n" + emailBody.getSenderPhone() + "\n";

            message.setText(messageBody);
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendEmailClient(EmailBody emailBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(AppConstants.RECIPIENT);
        message.setTo(emailBody.getSender());
        message.setSubject("Your Order Details");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            StringBuilder itemsBuilder = new StringBuilder();
            for (Order item : emailBody.getSenderOrder()) {
                itemsBuilder.append("- ")
                        .append(item.getTitle())
                        .append(" – Price: $").append(item.getPrice())
                        .append("\n");
            }

            // Build full email body
            String messageBody = "Dear " + emailBody.getSenderName() + ",\n\n"
                    + "Thank you for your recent order with us! Here are the details of your purchase:\n\n"
                    + "Order Summary:\n"
                    + "Items Ordered:\n" + itemsBuilder + "\n"
                    + "If you have any questions regarding your order, please reply to this email or contact us at support@company.com.\n\n"
                    + "We appreciate your business and look forward to serving you again.\n\n"
                    + "Best regards,\n"
                    + "Eyeshade Photography";

            message.setText(messageBody);
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
