package com.lec.ex12_account;

public class Account {
	private String acno;
	private String owna;
	private int bal;

	public Account(String acno, String owna, int bal) {
		this.acno = acno;
		this.owna = owna;
		this.bal = bal;
	}

	public Account(String acno, String owna) {
		this.acno = acno;
		this.owna = owna;

	}
	public void deposit(int amount) {
		bal += amount;
		System.out.println(owna+"님 "+amount+"원 입금되었습니다."+"잔액 : "+bal+"원");
	}
	public void withdraw(int amount) {
		bal -= amount;
		System.out.println(owna+"님 "+amount+"원 출금되었습니다."+"잔액 : "+bal+"원");
		
	}
	public void printAccount() {
		System.out.printf("계좌번호 : %s,  소유주 성함 : %s,  잔액 : %d원\n", acno,owna,bal);
	}

	public String getAcno() {
		return acno;
	}

	public void setAcno(String acno) {
		this.acno = acno;
	}

	public String getOwna() {
		return owna;
	}

	public void setOwna(String owna) {
		this.owna = owna;
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}
}
