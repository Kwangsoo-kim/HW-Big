package com.lec.ex03_phone;

public class Cmodel implements IAcor {
	private String na;

	public Cmodel() {
		na="Cmodel";
	}

	public Cmodel(String na) {
		this.na=na;
		
	}

	@Override
	public void dmb() {
		System.out.println(na + "�� DMB �۽� ����");

	}

	@Override
	public void lte() {
		System.out.println(na + "�� LTE");

	}

	@Override
	public void remotec() {
		System.out.println(na + "�� TV������ ��ž��");

	}


	public String getNa() {
		return na;
	}

}
