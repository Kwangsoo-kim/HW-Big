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
		System.out.println("~ ~ ~월급명세서 ~ ~ ~");
		System.out.println("성 함 : "+ na);
		System.out.println("월 급 : "+ cP());
		if(cP()>2000000) {
			System.out.println("상 여 : "+cI());
		}
		System.out.println("수고하셨습니다.");
	}
	public String getNa() {
		return na;
	}
	public void setNa(String na) {
		this.na = na;
	}
}
