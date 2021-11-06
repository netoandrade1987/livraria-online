package br.com.alura.livrariaonline.infra;

import java.util.Random;
import java.util.RandomAccess;

public class GeneratePassword {

	public static String generatePass() {

		String pass = new Random().nextInt(999999) + "";

		return pass;
	}

}
