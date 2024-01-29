package com.ltimindtree.email.entity;

import com.ltimindtree.email.model.EmailDetails;

//Interface
public interface EmailEntityService {
    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}
