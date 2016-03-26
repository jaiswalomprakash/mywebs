package com.webservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailServiceImpl implements EmailService {
	
    @Autowired
    private MailSender mailSender;
    @Autowired
    private SimpleMailMessage customeMailMessage;

	@Override
	public void sendMail(String to, String subject, String messageBody) {
		    SimpleMailMessage message = new SimpleMailMessage(customeMailMessage);
	        message.setTo(to);
	        message.setSubject(subject);
	        message.setText(messageBody);
	        mailSender.send(message);		
	}

}
