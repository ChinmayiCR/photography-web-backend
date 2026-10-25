package com.photographyweb.web.email;

import com.photographyweb.web.pojo.ClientQuery;
import com.photographyweb.web.pojo.EmailBody;

public interface EmailService {
    void sendEmail(EmailBody emailBody);
    void sendEmailClient(EmailBody emailBody);
    void sendEmailToAdmin(EmailBody emailBody);
    void sendClientQueryToAdmin(ClientQuery clientQuery);
}
