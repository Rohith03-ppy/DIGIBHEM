package com.login;

public class BankDetails {
	static private long balance;
	
	
	public static long showBalance() {
		return balance;
	}
	public static long deposit(long amt) {
		balance = balance + amt;
		return balance;
	}
	
	public static long withdraw(long amt) {
		if(balance >= amt) {
			balance = balance - amt;
		}else {
			
		}
		return balance;
	}
	
	
	public static void main(String args[]) {
		System.out.println(deposit(2000));
//		System.out.println(withdraw(500));
		System.out.print(deposit(500));
		System.out.println(withdraw(500));
	}
}
