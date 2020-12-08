package com.lec.ex08employee;

public class HourlyEmployee extends Employee {
	
	private int hw;
	private int mph; 
	public HourlyEmployee(String na, int hw, int mph) {
		super(na);
		this.hw=hw;
		this.mph=mph;
	}
	@Override
	public int cP() {
		return hw*mph;
	}
	public int getHw() {
		return hw;
	}
	public void setHw(int hw) {
		this.hw = hw;
	}
	public int getMph() {
		return mph;
	}
	public void setMph(int mph) {
		this.mph = mph;
	}

}
