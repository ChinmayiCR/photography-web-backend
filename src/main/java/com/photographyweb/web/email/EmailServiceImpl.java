package com.photographyweb.web.email;

import com.photographyweb.web.constants.AppConstants;
import com.photographyweb.web.pojo.ClientQuery;
import com.photographyweb.web.pojo.EmailBody;
import com.photographyweb.web.pojo.Order;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final String adminEmail = AppConstants.RECIPIENT;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    // an email to admin via client
    @Override
    public void sendEmail(EmailBody emailBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(adminEmail);
        message.setReplyTo(emailBody.getSender());
        message.setTo(AppConstants.RECIPIENT);
        message.setSubject(AppConstants.SUBJECT + " " + emailBody.getSenderName());
        message.setText(buildOwnerMessage(emailBody));
        mailSender.send(message);
    }

    @Override
    public void sendEmailClient(EmailBody emailBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(AppConstants.RECIPIENT);
        message.setTo(emailBody.getSender());
        message.setSubject("Your Order Details");
        message.setText(buildClientMessage(emailBody));
        mailSender.send(message);
    }

    @Override
    public void sendEmailToAdmin(EmailBody emailBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(adminEmail);
        message.setReplyTo(emailBody.getSender());
        message.setTo(adminEmail);
        message.setSubject(AppConstants.SUBJECT + " " + emailBody.getSenderName());
        message.setText(buildOwnerMessage(emailBody));
        mailSender.send(message);
    }

    @Override
    public void sendClientQueryToAdmin(ClientQuery clientQuery) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(adminEmail);
        message.setReplyTo(clientQuery.getSender());
        message.setTo(adminEmail);
        message.setSubject("Client Query: " + clientQuery.getSenderName());
        message.setText(buildClientQueryMessage(clientQuery));
        mailSender.send(message);
    }

    private String buildOwnerMessage(EmailBody emailBody) {
        return "You have an order from " + emailBody.getSenderName() + ",\n\n"
                + "Order Summary:\n"
                + "Items Ordered:\n" + buildItemsSummary(emailBody) + "\n"
                + "Client Phone Number:\n" + emailBody.getSenderPhone() + "\n";
    }

    private String buildClientMessage(EmailBody emailBody) {
        return "Dear " + emailBody.getSenderName() + ",\n\n"
                + "Thank you for your recent order with us! Here are the details of your purchase:\n\n"
                + "Order Summary:\n"
                + "Items Ordered:\n" + buildItemsSummary(emailBody) + "\n"
                + "If you have any questions regarding your order, please reply to this email or contact us at support@company.com.\n\n"
                + "We appreciate your business and look forward to serving you again.\n\n"
                + "Best regards,\n"
                + "Eyeshade Photography";
    }

    private String buildClientQueryMessage(ClientQuery clientQuery) {
        return "You have a new query from " + clientQuery.getSenderName() + ".\n\n"
                + "Client Email:\n" + clientQuery.getSender() + "\n\n"
                + "Client Phone Number:\n" + clientQuery.getSenderPhone() + "\n\n"
                + "Message:\n" + clientQuery.getMessage() + "\n";
    }

    private String buildItemsSummary(EmailBody emailBody) {
        StringBuilder itemsBuilder = new StringBuilder();

        if (emailBody.getSenderOrder() == null || emailBody.getSenderOrder().isEmpty()) {
            return "No items provided.\n";
        }

        for (Order item : emailBody.getSenderOrder()) {
            itemsBuilder.append("- ")
                    .append(item.getTitle())
                    .append(" - Price: $")
                    .append(item.getPrice())
                    .append("\n");
        }

        return itemsBuilder.toString();
    }
}
