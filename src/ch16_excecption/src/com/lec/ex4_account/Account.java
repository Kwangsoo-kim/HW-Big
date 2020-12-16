//201216 kks  new exception
package com.lec.ex4_account;

public class Account {
	private String ano;
	private String on;
	private int bal;
	public Account() {}
	public Account(String ano, String on) {
		this.ano = ano;
		this.on = on;
	}
	public Account(String ano, String on, int bal) {
		this.ano = ano;
		this.on = on;
		this.bal = bal;
	}
	public void deposit(int a) {
		System.out.println("예금 전 : "+this);
		bal+=a;
		System.out.println(a+"원 예금 후 : "+this);
	}
	public void withdraw(int b) throws Exception {
		if(bal<b) {//잔액부족으로 강제 예외발생
			throw new Exception(b+"원 출금하기에는 잔액("+bal+")이 부족합니다.");
		}
		System.out.println("출금 전 : "+this);
		bal-=b;
		System.out.println(b+"원 출금 후 : "+this);
	}
	@Override
	public String toString() {
		String result = "계좌번호 : "+ano+"\t 예금주 : "+on;
		result+="\t잔액 : "+bal;
		return result;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getOn() {
		return on;
	}
	public void setOn(String on) {
		this.on = on;
	}
	public int getBal() {
		return bal;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}
}
