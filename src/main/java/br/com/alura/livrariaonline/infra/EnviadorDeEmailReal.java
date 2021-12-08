package br.com.alura.livrariaonline.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class EnviadorDeEmailReal {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Async
	public void enviarEmail(String dest, String assunto, String msg) {
		
		SimpleMailMessage email = new SimpleMailMessage();
		
		email.setTo(dest);
		email.setSubject(assunto);
		email.setText(msg);
		
		
		mailSender.send(email);
		
		
	}
	
	
	
	
	

}
