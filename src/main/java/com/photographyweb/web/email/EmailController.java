package com.photographyweb.web.email;

import com.photographyweb.web.pojo.ClientQuery;
import com.photographyweb.web.pojo.EmailBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping({"/send", "/chat"})
    public String sendEmail(@RequestBody EmailBody request) {
        emailService.sendEmail(request);
        emailService.sendEmailClient(request);
        return "Email sent successfully!";
    }

    @PostMapping("/admin")
    public String sendEmailToAdmin(@RequestBody EmailBody request) {
        emailService.sendEmailToAdmin(request);
        return "Admin email sent successfully!";
    }

    @PostMapping("/query")
    public String sendClientQueryToAdmin(@RequestBody ClientQuery request) {
        emailService.sendClientQueryToAdmin(request);
        return "Client query sent to admin successfully!";
    }
}
