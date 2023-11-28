package com.itbank.component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class SHA512 {
	public String getHash(String pw) throws NoSuchAlgorithmException {
		String hash;
		MessageDigest md = MessageDigest.getInstance("SHA-512"); 
		
		md.reset();
		md.update(pw.getBytes());
		
		hash = String.format("%0128x", new BigInteger(1, md.digest()));
		
		return hash;
	}
}
