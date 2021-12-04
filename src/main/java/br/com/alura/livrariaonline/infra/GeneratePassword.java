package br.com.alura.livrariaonline.infra;

import java.util.Random;
import java.util.RandomAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneratePassword {

//	@Autowired
//	private BCryptPasswordEncoder encoder;

	public static String generatePass() {

	//	String pass = new Random().nextInt(999999) + "";
		
		//System.out.println(pass);

		return "123456";
	}

}
