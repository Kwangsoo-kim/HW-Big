package com.lec.ex12_account;

public class CheckingAccount extends Account {
	private String cn;
	public CheckingAccount(String acno,String owna,String cn) {
		super(acno,owna);
		this.cn=cn;

	}
	public CheckingAccount(String acno,String owna,int bal,String cn) {
		super(acno,owna,bal);
		this.cn=cn;

	}
	public void pay(String cn,int amount) {
		int bal=getBal();
		System.out.print(this.cn.equals(cn)? (amount>bal ? "잔액부족": amount+"원 결제.\t"): "계좌가 다릅니다. ");
		bal=bal-amount;
		System.out.println(bal>=0 ? "잔액 : "+bal+"원" : "결제 불가능");
	}
	public String getCn() {
		return cn;
	}
	public void setCn(String cn) {
		this.cn = cn;
	}
	
}
