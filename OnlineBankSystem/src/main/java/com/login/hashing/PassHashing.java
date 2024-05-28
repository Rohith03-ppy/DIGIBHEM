package com.login.hashing;

import java.security.MessageDigest;

public class PassHashing {
	public  String doHashing(String str) {
		try {
			MessageDigest message = MessageDigest.getInstance("MD5");
			message.update(str.getBytes());
			byte[] resultByteArray = message.digest();
			StringBuilder sb = new StringBuilder();
			for(byte b: resultByteArray) {
				sb.append(String.format("%02X", b));
			}
			return sb.toString();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	
}
