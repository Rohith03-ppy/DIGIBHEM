package com.login;

public class CusAddress {
	private String accountNumber;
    private String add1;
    private String state;
    private String add2;
    private String zip;
    
    public CusAddress(String accountNumber, String add1, String state, String add2, String zip) {
        this.accountNumber = accountNumber;
        this.add1 = add1;
        this.state = state;
        this.add2 = add2;
        this.zip = zip;
        
    }

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAdd1() {
		return add1;
	}

	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAdd2() {
		return add2;
	}

	public void setAdd2(String add2) {
		this.add2 = add2;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
    
    
    
}
