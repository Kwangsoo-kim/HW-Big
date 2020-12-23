//201217 kks exemple
package com.lec.ex1_list;

public class Customer {
	private String na;
	private String pn;
	private String ad;
	public Customer() {};
	public Customer(String na,String pn,String ad) {
		this.na=na;
		this.pn=pn;
		this.ad=ad;
	}
	@Override
	public String toString() {
		return na+"\t"+pn+"\t"+ad;
	}
	
}
