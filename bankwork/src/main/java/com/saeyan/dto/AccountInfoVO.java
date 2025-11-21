package com.saeyan.dto;

/*
create table accountinfo (		
 num int auto_increment primary key,		
 account varchar(30) unique,		
 name varchar(100),		
 userid varchar(100),		
 alias varchar(100),		
 phone char(13),		
 balance bigint default 0,		
 status varchar(30)		
);
 */
public class AccountInfoVO {

	private int num;
	private String account;
	private String name;
	private String userid;
	private String alias;
	private String phone;
	private long balance;
	private String status;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
