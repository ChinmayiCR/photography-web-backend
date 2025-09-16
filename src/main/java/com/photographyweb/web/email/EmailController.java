package com.photographyweb.web.email;

import com.photographyweb.web.pojo.EmailBody;
import com.photographyweb.web.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailBody request) {
        emailService.sendEmail(request);
        emailService.sendEmailClient(request);
        return "Email sent successfully!";
    }
}


