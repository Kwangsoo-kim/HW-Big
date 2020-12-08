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
		System.out.print(this.cn.equals(cn)? (amount>bal ? "�ܾ׺���": amount+"�� ����.\t"): "���°� �ٸ��ϴ�. ");
		bal=bal-amount;
		System.out.println(bal>=0 ? "�ܾ� : "+bal+"��" : "���� �Ұ���");
	}
	public String getCn() {
		return cn;
	}
	public void setCn(String cn) {
		this.cn = cn;
	}
	
}
