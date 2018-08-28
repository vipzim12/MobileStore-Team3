package com.team3.app.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MD5 implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(rawPassword.toString().getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		if(encode(rawPassword).equals(encodedPassword)) {
			return true;
		}
		return false;
	}
	
}
