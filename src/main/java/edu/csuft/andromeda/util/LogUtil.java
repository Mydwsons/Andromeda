package edu.csuft.andromeda.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LogUtil {
	public static String encryptBySHA256(String password) throws NoSuchAlgorithmException {
//		byte[] buf = MessageDigest.getInstance("SHA-256").digest(password.getBytes());
//		new BigInteger(1, MessageDigest.getInstance("SHA-256").digest(password.getBytes())).toString(16);
		return new BigInteger(1, MessageDigest.getInstance("SHA-256").digest(password.getBytes())).toString(16);
	}
}
