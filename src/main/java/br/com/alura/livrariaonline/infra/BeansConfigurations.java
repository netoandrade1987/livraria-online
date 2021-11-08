package br.com.alura.livrariaonline.infra;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BeansConfigurations {
	
	
	@Bean
	public BCryptPasswordEncoder getEncoder() {
		
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		
		return new ModelMapper();
		
	}
	

}
