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
		System.out.println("���� �� : "+this);
		bal+=a;
		System.out.println(a+"�� ���� �� : "+this);
	}
	public void withdraw(int b) throws Exception {
		if(bal<b) {//�ܾ׺������� ���� ���ܹ߻�
			throw new Exception(b+"�� ����ϱ⿡�� �ܾ�("+bal+")�� �����մϴ�.");
		}
		System.out.println("��� �� : "+this);
		bal-=b;
		System.out.println(b+"�� ��� �� : "+this);
	}
	@Override
	public String toString() {
		String result = "���¹�ȣ : "+ano+"\t ������ : "+on;
		result+="\t�ܾ� : "+bal;
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
