package com.login;

public class Transaction {
	private int id;
    private String accountNumber;
    private String type;
    private double amount;
    private double balanceAfter;
    private String date;

    public Transaction(int id, String accountNumber, String type, double amount, double balanceAfter, String date) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.date = date;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAcc() {
		return accountNumber;
	}

	public void setAcc(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalanceAfter() {
		return balanceAfter;
	}

	public void setBalanceAfter(double balanceAfter) {
		this.balanceAfter = balanceAfter;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
    
    
}
