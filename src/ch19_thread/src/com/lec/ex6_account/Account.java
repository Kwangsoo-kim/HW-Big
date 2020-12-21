package com.lec.ex6_account;

public class Account {
	private int bal;

	public Account() {
	}

	public Account(int bal) {
		this.bal = bal;
	}

	public synchronized void deposit(int amount, String who) {
		System.out.println(who + " 가 입금 시작 ~ ~ ~");
		System.out.println("입금전 잔액  : " + bal);
		bal += amount;
		System.out.println(amount + " 원 입금 후 잔액 : " + bal);
		System.out.println(who + " 가 입금 끝~ ~ ~");
	}
	public synchronized void withdraw (int amount, String who) {
		System.out.println(who+" 가 출금 시작 ~ ~ ~");
		System.out.println("출금전 잔액 : "+ bal);
		if(bal<amount) {
			System.out.println("잔액부족 출금 불가");
		}else {
			bal-=amount;
			System.out.println(amount+" 원 출금 후 잔액 : "+bal);
		}
		System.out.println(who+" 가 출금 끝 ~ ~ ~ ");
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}
}
