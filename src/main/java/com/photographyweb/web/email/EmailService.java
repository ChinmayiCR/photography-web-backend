package com.photographyweb.web.email;

import com.photographyweb.web.pojo.EmailBody;
import com.photographyweb.web.pojo.Order;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmailService{

    public void sendEmail(EmailBody emailBody);
    public void sendEmailClient(EmailBody emailBody);
}
