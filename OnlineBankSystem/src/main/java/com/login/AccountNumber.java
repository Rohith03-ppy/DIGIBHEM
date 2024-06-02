package com.login;

import java.util.Random;

public class AccountNumber {

	public String generateAccountNumber() {

        String commonPrefix = "2024";

        Random random = new Random();
        StringBuilder remainingDigitsBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            remainingDigitsBuilder.append(random.nextInt(10)); 
        }
        String accountNumber = commonPrefix + remainingDigitsBuilder.toString();

        return accountNumber;
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.println(generateAccountNumber());
//	}

}
