package com.saeyan.dto;

/* 
 create table depositinfo (
 num int auto_increment primary key,
 account  varchar(30),
 name varchar(100),
 depositdate timestamp default current_timestamp,
 flag  varchar(30),
 money bigint default 0,
 balance bigint default 0,
 memo varchar(100)
);
 
 */
public class DepositInfoVO {
	
	private int num;
	private String account;
	private String name;
	private String depositdate;
	private String flag;
	private long money;
	private long balance;
	private String memo;
	
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
	public String getDepositdate() {
		return depositdate;
	}
	public void setDepositdate(String depositdate) {
		this.depositdate = depositdate;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

}
