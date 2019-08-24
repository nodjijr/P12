package com.nodji.api.utils;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
	
	public static String generateBCrypt(String pass) {
		if (pass==null) {
			return pass;
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(pass);
	}

	public static boolean passValid(String pass, String passEncoded) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(pass, passEncoded);
	}
}
