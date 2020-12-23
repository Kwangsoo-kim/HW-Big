package com.lec.ex06lunch;

//Child1 c = new Child1(350,1000,100,300,800,350);
//Child2 c = new Child2(350,1000,100,300,800,350);
public abstract class LunchMenu {
	private int ri; // �Ұ�
	private int bg; // ��Ⱚ
	private int sp; // ����
	private int ba; // �ٳ�����
	private int mk; // ������
	private int al; // �Ƹ�尪

	public LunchMenu(int ri, int bg, int sp, int ba, int mk, int al) {
		this.ri = ri;
		this.bg = bg;
		this.sp = sp;
		this.ba = ba;
		this.mk = mk;
		this.al = al;
	}

	public LunchMenu(int ri, int bg, int sp, int ba, int al) {
		super();
		this.ri = ri;
		this.bg = bg;
		this.sp = sp;
		this.ba = ba;
		this.al = al;
	}

	public LunchMenu(int ri, int bg, int sp, int mk) {
		super();
		this.ri = ri;
		this.bg = bg;
		this.sp = sp;
		this.mk = mk;
	}

	// �Ĵ����ϴ� �޼ҵ�� �߻�޼ҵ�
	public abstract int calculate();

	public int getRi() {
		return ri;
	}

	public int getBg() {
		return bg;
	}

	public int getSp() {
		return sp;
	}

	public int getBa() {
		return ba;
	}

	public int getMk() {
		return mk;
	}

	public int getAl() {
		return al;
	}
}
