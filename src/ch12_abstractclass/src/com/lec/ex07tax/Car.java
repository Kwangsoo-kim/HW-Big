package com.lec.ex07tax;

public abstract class Car {
	private String cl;
	private String tr;
	private int dp;
	private String hd;

	public Car(String cl, String tr, int dp, String hd) {
		this.cl = cl; // 색상
		this.tr = tr; // 타이어
		this.dp = dp; // 배기량
		this.hd = hd; // 핸들
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
