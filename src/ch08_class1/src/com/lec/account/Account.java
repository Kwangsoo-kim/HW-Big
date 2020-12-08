package com.lec.account;

/*������� Ŭ���� 
 *  ������ : 	���¹�ȣ(ac:String)
 *			������   (on:String)
 *  		�ܾ�	  (bal:int)
 *  �޼ҵ� : 	�����Ѵ�(void dp(int money))
 *  		�����ϴ�(void wd(int money)), �ܾ׺��� 
 *  
 *  
 *  
 */
public class Account {
	private String ac;
	private String on;
	private int bal;

	public Account() {
	}

	public Account(String ac, String on, int bal) {
		this.ac = ac;
		this.on = on;
		this.bal = bal;
	}

	public Account(String ac, String on) {
		this.ac = ac;
		this.on = on;
	}

	public void dp(int money) {
		bal += money;
		System.out.println(money + "�� ���ݵǾ���");
	}
	public void info() {
		System.out.println("���¹�ȣ : "+ ac +","+on+"�� �ܾ��� : "+bal+"��");
	}

	public void wd(int money) { // �ܾ� ������ ���� return
		// System.out.println(bal>=money ? bal-=money : "?" );

		if (bal >= money) {
			bal -= money;
		} else {
			System.out.println("�ܾ� ����. ����");
		}
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	public void setOn(String on) {
		this.on = on;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	public String getAc() {
		return ac;
	}

	public String getOn() {
		return on;
	}

	public int getBal() {
		return bal;
	}
}
