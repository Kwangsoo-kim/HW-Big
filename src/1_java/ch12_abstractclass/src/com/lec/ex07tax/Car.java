package com.lec.ex07tax;

public abstract class Car {
	private String cl;
	private String tr;
	private int dp;
	private String hd;

	public Car(String cl, String tr, int dp, String hd) {
		this.cl = cl; // ����
		this.tr = tr; // Ÿ�̾�
		this.dp = dp; // ��ⷮ
		this.hd = hd; // �ڵ�
	}

	public abstract void getSpec();

	public String getCl() {
		return cl;
	}

	public String getTr() {
		return tr;
	}

	public int getDp() {
		return dp;
	}

	public String getHd() {
		return hd;
	}

}
