package com.lec.ex03_phone;

public class Amodel implements IAcor {
	private String na;

	public Amodel() {
		na="Amodel";
	}

	public Amodel(String na) {
		this.na=na;
		
	}

	@Override
	public void dmb() {
		System.out.println(na + "은 DMB 송신 불가");

	}

	@Override
	public void lte() {
		System.out.println(na + "은 5G");

	}

	@Override
	public void remotec() {
		System.out.println(na + "은 TV리모콘 미탑재");

	}

	public String getNa() {
		return na;
	}

}
