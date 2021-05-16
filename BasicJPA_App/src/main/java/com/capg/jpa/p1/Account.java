package com.capg.jpa.p1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity   
@Table(name = "MyAccounts")
public class Account {
	
	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "accountNumber")
	private int accId;
	
	@Column(name=" AccountName")
	private String accountHolderName;
	
	private int balance;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accId, String accountHolderName, int balance) {
		super();
		this.accId = accId;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accId=" + accId + ", accountHolderName=" + accountHolderName + ", balance=" + balance + "]";
	}
	
	

}