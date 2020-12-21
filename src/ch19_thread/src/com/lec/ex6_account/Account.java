//201221 kks thread_example
package com.lec.ex6_account;

public class Account {
	private int bal;

	public Account() {
	}

	public Account(int bal) {
		this.bal = bal;
	}

	public synchronized void deposit(int amount, String who) {
		System.out.println(who + " �� �Ա� ���� ~ ~ ~");
		System.out.println("�Ա��� �ܾ�  : " + bal);
		bal += amount;
		System.out.println(amount + " �� �Ա� �� �ܾ� : " + bal);
		System.out.println(who + " �� �Ա� ��~ ~ ~");
	}
	public synchronized void withdraw (int amount, String who) {
		System.out.println(who+" �� ��� ���� ~ ~ ~");
		System.out.println("����� �ܾ� : "+ bal);
		if(bal<amount) {
			System.out.println("�ܾ׺��� ��� �Ұ�");
		}else {
			bal-=amount;
			System.out.println(amount+" �� ��� �� �ܾ� : "+bal);
		}
		System.out.println(who+" �� ��� �� ~ ~ ~ ");
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}
}
