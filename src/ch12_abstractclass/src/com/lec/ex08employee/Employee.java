package com.lec.ex08employee;

public abstract class Employee {
	private String na;
	public Employee(String na) {
		this.na=na;
	}
	
	public abstract int cP();
	public final int cI() {
		return cP()/10;
	}
	public void payinfo() {
		System.out.println("~ ~ ~���޸��� ~ ~ ~");
		System.out.println("�� �� : "+ na);
		System.out.println("�� �� : "+ cP());
		if(cP()>2000000) {
			System.out.println("�� �� : "+cI());
		}
		System.out.println("�����ϼ̽��ϴ�.");
	}
	public String getNa() {
		return na;
	}
	public void setNa(String na) {
		this.na = na;
	}
}
