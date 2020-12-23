//20.12.15 kks example
package com.lec.ex07_market;

public class Customer {
	private String tel;
	private String name;
	private int point;
	private int amount;
	public Customer(String tel,String name) {
		this.tel=tel;
		this.name=name;
		this.point=3000;
		this.amount=amount;
	}
	@Override
	public String toString() {
		return name+"("+tel.substring(tel.lastIndexOf("-")+1)+")"+""+" 포인트 : "+point+", 누적금액 : "+amount;
		
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Customer) {
			return tel==((Customer)obj).tel;
		}
		return false;
	}
	public String getTel() {
		return tel;
	}
	public String getName() {
		return name;
	}
	public int getPoint() {
		return point;
	}
	public int getAmount() {
		return amount;
	}
}
