package com.ltimindtree.email.controller;

import com.ltimindtree.email.model.EmailDetails;
import com.ltimindtree.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    // Sending a simple Email
    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String sendMail(@RequestBody EmailDetails details){
        String status = emailService.sendSimpleMail(details);
        return status;
    }

    // Sending email with attachment
    @RequestMapping(value = "/sendMailWithAttachment")
    @ResponseStatus(HttpStatus.OK)
    public String sendMailWithAttachment(@RequestBody EmailDetails details){
        String status = emailService.sendMailWithAttachment(details);
        return status;
    }
}
