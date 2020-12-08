package com.lec.ex08employee;

public class SalaryEmployee extends Employee {
	private int as;
	public SalaryEmployee(String na, int as) {
		super(na);
		this.as=as;
	}
	@Override
	public int cP() {
		return as/14;
	}
	public int getAs() {
		return as;
	}
	public void setAs(int as) {
		this.as = as;
	}
}
