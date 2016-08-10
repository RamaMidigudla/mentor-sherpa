/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.web.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Service("mailService")
public class AppMailSender {

//    @Autowired
    private MailSender mailSender;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

//    @Autowired
//    private SimpleMailMessage preConfiguredMessage;

    /**
     * This method will send compose and send the message 
     *
     */
    public void sendMail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    public void send(SimpleMailMessage message) {
        mailSender.send(message);
    }

    /**
     * This method will send a pre-configured message
     *
     */
//    public void sendPreConfiguredMail(String message) {
//        SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
//        mailMessage.setText(message);
//        mailSender.send(mailMessage);
//    }
}
