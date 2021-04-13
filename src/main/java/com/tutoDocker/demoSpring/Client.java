package com.tutoDocker.demoSpring;

public class Client {

	private String firstname;
	private String lastname;
	private int id;
	private int account;
	
	// constructor
	public Client(String fName, String lName, int nId, int account) {
		this.id = nId;
		this.firstname = fName;
		this.lastname = lName;
		this.account = account;
	}
		
	public Client() {
		this.id = 404;
		this.firstname = "George";
		this.lastname = "Lucas";
		this.account = 10000;
	}
	
	// getter
	public int getId() {
		return this.id;
	}
	public String getFirstName() {
		return this.firstname;
	}
	public String getLastName() {
		return this.lastname;
	}
	public int getAccount() {
		return this.account;
	}
	
	// simple display function
	public void displayInfo() {
		System.out.println("Client: ID:"+this.id + " " + this.firstname+ " " + this.lastname + " - Account: "+ this.account +"$");
	}
	
	
}
