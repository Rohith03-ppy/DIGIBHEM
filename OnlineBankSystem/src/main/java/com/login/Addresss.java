package com.login;

public class Addresss {
	private String accountNumber;
	    private String pan;
	    private String adhar;
	    private String email;
	    private String phone;
	    
	    public Addresss(String accountNumber, String pan, String adhar, String email, String phone) {
	        this.accountNumber = accountNumber;
	        this.pan = pan;
	        this.adhar = adhar;
	        this.email = email;
	        this.phone = phone;
	        
	    }
	    
	    
	    
	    
	    
	    public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public String getPan() {
			return pan;
		}
		public void setPan(String pan) {
			this.pan = pan;
		}
		public String getAdhar() {
			return adhar;
		}
		public void setAdhar(String adhar) {
			this.adhar = adhar;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
	    
	    
}
