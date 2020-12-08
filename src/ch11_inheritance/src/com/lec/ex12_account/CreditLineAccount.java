package com.lec.ex12_account;

public class CreditLineAccount extends CheckingAccount{
	private long cl;
	public CreditLineAccount(String acno,String owna,int bal,String cn,long cl) {
		super(acno,owna,bal,cn);
		this.cl=cl;
	}
	public void pay(String cn,int amount) {
		
		System.out.print(getCn().equals(cn)? (amount>cl ? "�ѵ��ʰ�, ": amount+"�� ����.\t"): "ī���ȣ�� �ٸ��ϴ�.   ");
		cl=cl-amount;
		System.out.println(cl>=0 ? ("ī���ѵ� : "+cl+"�� ���ҽ��ϴ�."): "�����Ұ���");
	}
	@Override
	public void printAccount() {
		super.printAccount();
		System.out.println("ī�� �ѵ��� : "+ cl);
	}
	public long getCl() {
		return cl;
	}
	public void setCl(long cl) {
		this.cl = cl;
	}

}
