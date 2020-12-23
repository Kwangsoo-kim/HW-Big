package com.lec.ex03_phone;

public class Bmodel implements IAcor {
	private String na;

	public Bmodel() {
		na="Bmodel";
	}

	public Bmodel(String na) {
		this.na=na;
		
	}

	@Override
	public void dmb() {
		System.out.println(na + "은 DMB 송신 가능");

	}

	@Override
	public void lte() {
		System.out.println(na + "은 LTE");

	}

	@Override
	public void remotec() {
		System.out.println(na + "은 TV리모콘 탑재");

	}


	public String getNa() {
		return na;
	}

}
