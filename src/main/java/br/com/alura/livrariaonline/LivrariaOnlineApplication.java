package br.com.alura.livrariaonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 
 * @author Neto Andrade
 * @version 1.0
 * 
 * Descrição: Essa classe é responsável por dar o startup na aplicação. 
 *
 *
 */

@SpringBootApplication
@EnableAsync
public class LivrariaOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariaOnlineApplication.class, args);
	}

}
