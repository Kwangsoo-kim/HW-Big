//201216 kks new exception
package com.lec.ex4_account;
//예외를 만든 곳은 메인에서 try,catch문을 잡아줘야한다.
public class AccountMain {
	public static void main(String[] args) {
		Account a1 = new Account("11-11","홍길동");
		Account a2 = new Account("22-22","이길동",20000);
		a1.deposit(10000);
		a2.deposit(10000);
		try {
			a1.withdraw(15000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
