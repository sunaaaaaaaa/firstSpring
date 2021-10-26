package com.kh.spring.common.mail;

import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.kh.spring.common.code.Config;
import com.kh.spring.common.code.ErrorCode;
import com.kh.spring.common.exception.HandlableException;

@Component
public class MailSender {
	
	JavaMailSender mailSender;
	
	public MailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendEmail(String to, String subject, String htmlText) {
			

		MimeMessage msg = mailSender.createMimeMessage();
       
        try {
        	msg.setFrom(Config.COMPANY_EMAIL.DESC); //회사이메일
            msg.setRecipients(Message.RecipientType.TO,to); //받는사람
			msg.setSubject(subject);//내용
			msg.setSentDate(new Date());
	        msg.setText(htmlText,"utf-8","html"); //제목
	        mailSender.send(msg);//담아줌
	        
		} catch (MessagingException e) {
			throw new HandlableException(ErrorCode.MAIL_SEND_FAIL_ERROR); //Exception발생시 메일잘못보냄
		}
        
	}
	

}
