package com.lec.ex06lunch;

public class Child2 extends LunchMenu {

	public Child2(int ri, int bg, int sp, int ba, int mk, int al) {
		super(ri, bg, sp, ba, mk, al);
	}

	@Override
	public int calculate() {
		return getBg()+getMk()+getSp()+getRi();
	}

}
