package br.com.alura.livrariaonline.infra;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Profile({"default","test"})
public class EnviadorDeEmailFake {
	
	
	@Async
	public void enviarEmail(String dest, String assunto, String msg) {
		
		System.out.println("Enviando Email...");
		System.out.println("Destinatário : "+ dest);
		System.out.println("Assunto :"+ assunto);
		System.out.println("Mensagem: "+ msg);
		
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}
	
	
	
	

}
