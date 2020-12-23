package com.lec.man;

//Man Kim = new Man(20,160,50,"010-9999-9999");
//Man yi = new Man(20,170,60);
//Man prak = new Man(20,"010-9999-9999");
public class Man {
	private int a;
	private int h;
	private int w;
	private String pn; // ��ȭ��ȣ�� �ݵ�� string���� ���� �չ�ȣ 0�� �߸���.

	public Man() {
	}

	public Man(int a, int h, int w, String pn) {
		this.a = a;
		this.h = h;
		this.w = w;
		this.pn = pn;
	}

	public Man(int a, int h, int w) {
		this.a = a;
		this.h = h;
		this.w = w;
	}

	public Man(int a, String pn) {
		this.a = a;
		this.pn = pn;
	}

	// BMI������ ��ȯ�ϴ� �޼ҵ�
	public double cB() {
		double result = w / ((h * 0.01) * (h * 0.01));
		return result;
	}

	public void setA(int a) {
		this.a = a;
	}

	public void setH(int h) {
		this.h = h;
	}

	public void setW(int w) {
		this.w = w;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	public int getA() {
		return a;
	}

	public int getH() {
		return h;
	}

	public int getW() {
		return w;
	}

	public String getPn() {
		return pn;
	}
}
