package com.login;

public class Customer {
	private String accountNumber;
	private String firstname;
    private String lastname;
    private String fathername;
    private String mothername;
    private String gender;
    private String dob;
    private String acctype;
    private double balance;
    
    
    public Customer(String accountNumber, String firstname, String lastname, String fathername, String mothername, String gender, String dob, String acctype, double balance) {
        this.accountNumber = accountNumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.fathername = fathername;
        this.mothername = mothername;
        this.gender = gender;
        this.dob = dob;
        this.acctype = acctype;
        this.balance = balance;
    }
    
    
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getFathername() {
		return fathername;
	}


	public void setFathername(String fathername) {
		this.fathername = fathername;
	}


	public String getMothername() {
		return mothername;
	}


	public void setMothername(String mothername) {
		this.mothername = mothername;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getAcctype() {
		return acctype;
	}


	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
    
    
}
