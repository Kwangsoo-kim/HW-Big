package com.lec.ex06lunch;

//Child1 c = new Child1(350,1000,100,300,800,350);
//Child2 c = new Child2(350,1000,100,300,800,350);
public abstract class LunchMenu {
	private int ri; // 쌀값
	private int bg; // 고기값
	private int sp; // 국값
	private int ba; // 바나나값
	private int mk; // 우유값
	private int al; // 아몬드값

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

	// 식대계산하는 메소드는 추상메소드
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
