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
		System.out.println(na + "�� DMB �۽� �Ұ�");

	}

	@Override
	public void lte() {
		System.out.println(na + "�� 5G");

	}

	@Override
	public void remotec() {
		System.out.println(na + "�� TV������ ��ž��");

	}

	public String getNa() {
		return na;
	}

}
