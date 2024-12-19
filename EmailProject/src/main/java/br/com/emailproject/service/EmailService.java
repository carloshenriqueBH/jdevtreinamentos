package br.com.emailproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import br.com.emailproject.model.Email;
import br.com.emailproject.util.LogUtil;
import jakarta.ejb.Stateless;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

@Stateless
public class EmailService extends Thread {
	
	private List<Email> emails;
	
	public static final String HEADER_CONTEXT = "text/html; charset=utf-8";
	
	public void enviar(Email email) {
		emails = new ArrayList<>();
		emails.add(email);
		send();
	}
	
	public void enviar(List<Email> emails) {
		this.emails = emails;
		send();
	}
	private EmailService copy() {
		EmailService emailService = new EmailService();
		emailService.emails= emails;
		return emailService;
	}
	private void send() {
		new Thread(this.copy()).start();;
	}
	@Override
	public void run() {
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", System.getProperty("email-project.mail.smtp.host"));
		props.put("mail.smtp.port",  System.getProperty("email-project.mail.smtp.port"));
		
		Session session =  Session.getInstance(props);
		session.setDebug(false);
		
		for (Email email : emails) {
			Message message = new MimeMessage(session);
			try {
				message.setFrom(new InternetAddress(System.getProperty("email-project.mail.from")));
				if (email.getDestinatario().contains("/")) {
					List<InternetAddress> emailsLocal = new ArrayList<>();
					for (String e: email.getDestinatario().split("/")) {
						emailsLocal.add(new InternetAddress(e));
					}
					message.addRecipients(Message.RecipientType.TO, emailsLocal.toArray(new InternetAddress[0]));
				} else {
					InternetAddress para = new InternetAddress(email.getDestinatario());
					message.addRecipient(Message.RecipientType.TO, para);
				}
				message.setSubject(email.getAssunto());
				MimeBodyPart textPart = new MimeBodyPart();
				textPart.setHeader("content-type", HEADER_CONTEXT);
				textPart.setContent(email.getTexto(),HEADER_CONTEXT);
				Multipart mp = new MimeMultipart();
				mp.addBodyPart(textPart);
				message.setContent(mp);
				Transport.send(message);
				
				
			} catch (MessagingException e) {
				LogUtil.getLogger(EmailService.class).error("Erro ao enviar email: "+e.getMessage());
			}
			
		}
	}

}
