package com.bookstore.config;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtility {
	private static final String SALT = "salt"; //salt should be protected carefully, separate it to external file
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
	}
	
	@Bean
	public static String randomPassword(){
		String SALTCHARS = "ABCDEFHGIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rand = new Random();
		
		while(salt.length() < 18){
			int index = (int) (rand.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS).charAt(index);
		}
		
		String saltStr = salt.toString();
		return saltStr;
		
		
	}
}
