package com.lec.ex12_account;

public class CreditLineAccount extends CheckingAccount{
	private long cl;
	public CreditLineAccount(String acno,String owna,int bal,String cn,long cl) {
		super(acno,owna,bal,cn);
		this.cl=cl;
	}
	public void pay(String cn,int amount) {
		
		System.out.print(getCn().equals(cn)? (amount>cl ? "한도초과, ": amount+"원 결제.\t"): "카드번호가 다릅니다.   ");
		cl=cl-amount;
		System.out.println(cl>=0 ? ("카드한도 : "+cl+"원 남았습니다."): "결제불가능");
	}
	@Override
	public void printAccount() {
		super.printAccount();
		System.out.println("카드 한도액 : "+ cl);
	}
	public long getCl() {
		return cl;
	}
	public void setCl(long cl) {
		this.cl = cl;
	}

}
